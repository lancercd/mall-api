package com.mall.api.controller;

import com.mall.api.service.OrderService;
import com.mall.core.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/recent")
    public Object recentOrder() {
        return ResponseUtil.ok(orderService.getRecentOrder());
    }
}
