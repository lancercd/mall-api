package com.mall.core.storage.config;


import com.mall.core.storage.LocalStorage;
import com.mall.core.storage.StorageService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class StorageAutoConfiguration {

    private final StorageProperties properties;

    public StorageAutoConfiguration(StorageProperties properties) {
        this.properties = properties;
    }

    @Bean
    public StorageService storageService() {
        StorageService storageService = new StorageService();
        String active = this.properties.getActive();
        storageService.setActive(active);
        if (active.equals("local")) {
            storageService.setStorage(localStorage());
        } else {
            throw new RuntimeException("当前存储模式 " + active + " 不支持");
        }

        return storageService;
    }


    @Bean
    public LocalStorage localStorage() {
        LocalStorage localStorage = new LocalStorage();
        StorageProperties.Local local = this.properties.getLocal();
        localStorage.setAddress(local.getAddress());
        String storagePath = local.getStoragePath();

        // 默认上传到跟目录
        if(null == storagePath) storagePath = "storage";
        else if(!storagePath.endsWith("/") || !storagePath.endsWith("\\")) {
            storagePath = storagePath + File.separatorChar;
        }
        Path path = Paths.get(storagePath);

        localStorage.setStorageStrPath(path.toString());
        localStorage.setStoragePath(path);
        return localStorage;
    }

}
