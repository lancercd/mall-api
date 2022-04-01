package com.mall.core.api;

import com.mall.core.storage.StorageService;
import com.mall.core.utils.File.FileUtil;
import com.mall.core.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileUploadApi {

    @Autowired
    private StorageService storageService;

    @PostMapping("/api/upload/image")
    public Object uploadImage(@RequestParam("image") MultipartFile image) throws IOException {
        String originalFilename = image.getOriginalFilename();
        String url = storageService.store(image.getInputStream(),
                                          image.getSize(),
                                          image.getContentType(),
                                          originalFilename);

        Map<String, Object> data = new HashMap<>();
        data.put("url", url);
        return ResponseUtil.ok(data);
    }

    /**
     * 访问存储对象
     * @param fileName 存储对象filename
     * @return ResponseEntity<Resource>
     */
    @GetMapping("/storage/fetch/{year}/{month}/{day}/{fileName:.+}")
    public ResponseEntity<Resource> imageFetch(@PathVariable String year,
                                               @PathVariable String month,
                                               @PathVariable String day,
                                               @PathVariable String fileName
    ) {

        String path = year + '/' + month + '/' + day + '/' + fileName;

        if (year == null) {
            return ResponseEntity.notFound().build();
        }
        if (year.contains("../") || year.contains("./")) {
            return ResponseEntity.badRequest().build();
        }

        return this.getFile(path);
    }

    /**
     * 访问存储对象
     * @param fileName 存储对象filename
     * @return ResponseEntity<Resource>
     */
    @GetMapping("/storage/fetch/{type}/{fileName:.+}")
    public ResponseEntity<Resource> localFetch(@PathVariable String type,
                                               @PathVariable String fileName
    ) {

        String path = "img/" + type + '/' + fileName;

        if (type == null || fileName == null) {
            return ResponseEntity.notFound().build();
        }
        if (type.contains("../") || type.contains("./")) {
            return ResponseEntity.badRequest().build();
        }
        return this.getFile(path);
    }

    private ResponseEntity<Resource> getFile(String path) {
        Resource file = null;
        try {
            file = storageService.loadAsResource(path);
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }


        MediaType mediaType = MediaType.parseMediaType(FileUtil.getMediaType(file.getFilename()));


        return ResponseEntity.ok().contentType(mediaType).body(file);
    }
}
