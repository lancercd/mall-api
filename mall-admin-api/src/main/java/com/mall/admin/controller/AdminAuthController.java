package com.mall.admin.controller;


import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.Admin;
import com.mall.db.service.AdminBaseService;
import com.mall.db.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Object login(@RequestBody Admin admin) {

        System.out.println(admin);

        String username = admin.getUsername();
        if (StringUtil.isEmpty(username)) {
            return ResponseUtil.fail("用户名不能为空!");
        }
        String password = admin.getPassword();
        if (StringUtil.isEmpty(password)) {
            return ResponseUtil.fail("密码不能为空!");
        }

        Admin adminUser = adminBaseService.findByUsername(username);

        if(adminUser == null) {
            return ResponseUtil.fail("用户不存在!");
        }

        String correctPwd = adminUser.getPassword();
        if (!correctPwd.equals(password)) {
            return ResponseUtil.fail("密码错误!");
        }

        adminUser.setPassword(null);
        Map<String, Object> res = new HashMap<>();
        res.put("token", "4sd65f4d3fa444fcs1ad4fds5da6f");
        res.put("user", adminUser);

        return ResponseUtil.ok(res);
    }

}
