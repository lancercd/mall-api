package com.mall.admin.controller;

import com.mall.admin.service.AdminSettingService;
import com.mall.core.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/setting")
public class AdminSettingController {

    @Autowired
    private AdminSettingService adminSettingService;

    @PostMapping("/banner/list")
    public Object bannerList() {
        return ResponseUtil.ok(adminSettingService.bannerList());
    }

}
