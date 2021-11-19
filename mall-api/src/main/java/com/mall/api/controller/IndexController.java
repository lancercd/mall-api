package com.mall.api.controller;

import com.mall.api.service.UserService;
import com.mall.core.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public Object test() {
        return "api";
    }

    @PostMapping("/db/test")
    public Object dbTest() {
        return ResponseUtil.ok(userService.get());
    }
}
