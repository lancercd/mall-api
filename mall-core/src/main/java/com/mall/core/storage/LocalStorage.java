package com.mall.core.storage;


import com.mall.core.sys.SysService;
import com.mall.core.utils.File.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

/**
 * 服务器本地对象存储服务
 */
public class LocalStorage implements Storage {

    private String address;

    private String storageStrPath;

    private Path storagePath;

    @Autowired
    private SysService sysService;

    /**
     * 文件分隔符
     */
    private static final char FILE_SEPARATOR = File.separatorChar;

    private static final String DATE_FORMATTER_STR = "yyyy" + FILE_SEPARATOR +"MM"+ FILE_SEPARATOR +"dd";


    public void setStorageStrPath(String storagePath) {
        this.storageStrPath = storagePath;
        FileUtil.forceMkdir(new File(storagePath));
    }

    public void setStoragePath(Path storagePath) {
        this.storagePath = storagePath;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String fileDirByTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATTER_STR);
        return sdf.format(new Date());
    }

    @Override
    public String store(InputStream inputStream, long contentLength, String contentType, String fileName) {

        String incompletePath = fileDirByTime() + FILE_SEPARATOR + fileName;
        String completePath = storageStrPath + FILE_SEPARATOR + incompletePath;

        FileUtil.forceMkdir(new File(completePath));

        try {
            Files.copy(inputStream, Paths.get(completePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + fileName, e);
        }
        return incompletePath;
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(storagePath, 1)
                    .filter(path -> !path.equals(storagePath))
                    .map(path -> storagePath.relativize(path));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return storagePath.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(String filename) {
        Path file = load(filename);
        try {
            Files.delete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String transformFileSeparator(String path) {
        return (FILE_SEPARATOR == '/')? path : path.replaceAll("\\\\", "/");
    }

    @Override
    public String generateUrl(String keyName) {
        return sysService.getUrl() + this.address + transformFileSeparator(keyName);
    }
}