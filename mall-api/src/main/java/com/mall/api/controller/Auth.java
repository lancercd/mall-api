package com.mall.api.controller;

import com.mall.api.annotation.support.UserTokenManager;
import com.mall.api.dao.UserToken;
import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class Auth {

    @PostMapping("/login")
    public Object login(@RequestBody User user) {

        UserToken userToken = UserTokenManager.generateToken(1);

        return ResponseUtil.ok(userToken);
    }

    @PostMapping("/test")
    public Object login() {

        return ResponseUtil.ok();
    }

}
