package com.mall.api.controller;

import com.mall.api.dto.request.UserLoginAndRegister;
import com.mall.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Object login(
            @RequestBody
            @Validated({UserLoginAndRegister.Login.class, Default.class})
            UserLoginAndRegister user
    ) {
        return userService.login(user);
    }

    @PostMapping("/register")
    public Object register(
            @RequestBody
            @Validated({UserLoginAndRegister.Register.class, Default.class})
            UserLoginAndRegister user
    ) {
        return userService.register(user);
    }
}
