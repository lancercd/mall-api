package com.mall.api.controller;

import com.mall.core.utils.FileUploadUtil;
import com.mall.core.utils.ResponseUtil;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.HashMap;


@RestController
public class UploadController {

    @PostMapping("/api/upload/image")
    public Object imageUpload(MultipartFile image) {
        if (image.getSize() == 0) {
            return ResponseUtil.fail(-1, "请选择图片");
        }

        String path = null;

        try {
            path = FileUploadUtil.save(image);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.fail(-1, "上传图片失败!");
        }



        HashMap<String, Object> res = new HashMap<>();
        res.put("url", path);
        res.put("name", image.getOriginalFilename());
        res.put("status", "done");

        return ResponseUtil.ok(res);
    }


    /**
     * 访问存储对象
     * @param key 存储对象key
     * @return ResponseEntity<Resource>
     */
    @GetMapping("/image/{key:.+}")
    public ResponseEntity<Resource> imageFetch(@PathVariable String key) {
        System.out.println(key);
        if (key == null) {
            return ResponseEntity.notFound().build();
        }
        if (key.contains("../") || key.contains("./")) {
            return ResponseEntity.badRequest().build();
        }

        Resource file = null;
        try {
            file = FileUploadUtil.loadAsResource(key);
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }


        MediaType mediaType = MediaType.parseMediaType(FileUploadUtil.getMediaType(file.getFilename()));


        return ResponseEntity.ok().contentType(mediaType).body(file);
    }
}
