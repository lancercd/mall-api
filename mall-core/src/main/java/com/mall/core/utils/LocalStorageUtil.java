package com.mall.core.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LocalStorageUtil {


    public static Path load(String pathAndFilename) {
        return Paths.get(pathAndFilename);
    }


    public static Resource loadAsResource(String filename) throws FileNotFoundException {
        // try {
            // Path file = load(filename);
            // Resource resource = new UrlResource(file.toUri());
            // Resource resource = new UrlResource(Paths.get(filename).toUri());
            Resource resource = new ClassPathResource(filename);
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            throw new FileNotFoundException("Path:" + filename);
        // } catch (MalformedURLException e) {
        //     e.printStackTrace();
        //     throw new FileNotFoundException();
        // }
    }

}
