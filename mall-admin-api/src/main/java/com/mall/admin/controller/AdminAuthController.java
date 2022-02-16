package com.mall.admin.controller;


import com.mall.admin.dto.AdminLogin;
import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.Admin;
import com.mall.db.service.AdminBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/auth")
public class AdminAuthController {

    @Autowired
    private AdminBaseService adminBaseService;


    @PostMapping("/login")
    public Object login(@RequestBody @Validated AdminLogin admin) {

        Admin adminUser = adminBaseService.findByUsername(admin.getUsername());

        if(adminUser == null) {
            return ResponseUtil.fail("用户不存在!");
        }

        String correctPwd = adminUser.getPwd();
        if (!correctPwd.equals(admin.getPwd())) {
            return ResponseUtil.fail("密码错误!");
        }

        adminUser.setPwd(null);

        // TODO token
        Map<String, Object> res = new HashMap<>();
        res.put("token", "4sd65f4d3fa444fcs1ad4fds5da6f");
        res.put("user", adminUser);

        return ResponseUtil.ok(res);
    }

}
