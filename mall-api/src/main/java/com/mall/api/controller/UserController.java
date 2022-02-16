package com.mall.api.controller;

import com.mall.api.annotation.support.UserTokenManager;
import com.mall.api.dao.UserToken;
import com.mall.core.utils.ResponseUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @PostMapping("/info")
    public Object userInfo() {

        UserToken userToken = UserTokenManager.generateToken(1);

        return ResponseUtil.ok(userToken);
    }

    @PostMapping("/edit/info")
    public Object edit() {

        UserToken userToken = UserTokenManager.generateToken(1);

        return ResponseUtil.ok(userToken);
    }
}
