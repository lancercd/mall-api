package com.mall.core.api;

import com.mall.core.storage.StorageService;
import com.mall.core.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/upload")
public class FileUploadApi {

    @Autowired
    private StorageService storageService;

    @PostMapping("/image")
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
}
