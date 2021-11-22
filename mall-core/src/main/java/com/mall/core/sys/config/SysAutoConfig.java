package com.mall.core.sys.config;

import com.mall.core.sys.SysService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SysProperties.class)
public class SysAutoConfig {
    private final SysProperties properties;

    public SysAutoConfig(SysProperties properties) {
        this.properties = properties;
    }

    @Bean
    public SysService sysService() {
        SysService sysService = new SysService();
        String url = this.properties.getUrl();
        if(null == url || !url.startsWith("http"))
            throw new RuntimeException("sys.url配置错误 必须以http开头!");

        sysService.setUrl(url);
        return sysService;
    }
}
