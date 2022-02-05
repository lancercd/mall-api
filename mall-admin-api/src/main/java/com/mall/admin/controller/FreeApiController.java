package com.mall.admin.controller;


import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.Category;
import com.mall.db.service.CategoryBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FreeApiController {

    @Autowired
    private CategoryBaseService categoryBaseService;

    @GetMapping("/test")
    public Object test() {

        List<Category> data = categoryBaseService.getList();
        return ResponseUtil.ok(data);
    }
}
