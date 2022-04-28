package com.mall.admin.controller;

import com.mall.admin.service.AdminGoodsService;
import com.mall.admin.service.AdminOrderService;
import com.mall.admin.service.AdminUserService;
import com.mall.core.utils.ResponseUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/dashboard")
public class AdminDashboardController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private AdminGoodsService adminGoodsService;

    @Autowired
    private AdminOrderService adminOrderService;

    @GetMapping("/index")
    public Object index() {
        Map<String, Map<String, Long>> map = new HashMap<>();
        map.put("user", adminUserService.countInfo());
        map.put("goods", adminGoodsService.countInfo());
        map.put("order", adminOrderService.countInfo());
        return ResponseUtil.ok(map);
    }
}
