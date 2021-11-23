package com.mall.core.storage;

import org.springframework.core.io.Resource;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * 提供存储服务类，所有存储服务均由该类对外提供
 */
public class StorageService {

    private String active;
    private Storage storage;

    private static final String EMPTY_STRING = "";

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * 随机文件名
     * @return RandomFileName
     */
    private static String getRandomFileName(String fileSuffix){
        return UUID.randomUUID().toString().replaceAll("-","") + fileSuffix;
    }

    /**
     * getFileSuffix
     * @return java.lang.String
     */
    public static String getFileSuffix(String fileName){
        int index = fileName.lastIndexOf(".");
        return index>-1 ? fileName.substring(index) : EMPTY_STRING;
    }


    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param fileName      文件索引名
     */
    public String store(InputStream inputStream, long contentLength, String contentType, String fileName) {
        String fileSuffix = getFileSuffix(fileName);
        String RandomFileName = getRandomFileName(fileSuffix);
        String incompletePath = storage.store(inputStream, contentLength, contentType, RandomFileName);

        return generateUrl(incompletePath);
    }



    public Stream<Path> loadAll() {
        return storage.loadAll();
    }

    public Path load(String keyName) {
        return storage.load(keyName);
    }

    public Resource loadAsResource(String keyName) throws FileNotFoundException {
        Resource resource = storage.loadAsResource(keyName);
        if (null == resource || !resource.exists() || !resource.isReadable()) {
            throw new FileNotFoundException();
        }

        return resource;
    }

    public void delete(String keyName) {
        storage.delete(keyName);
    }

    private String generateUrl(String keyName) {
        return storage.generateUrl(keyName);
    }
}
