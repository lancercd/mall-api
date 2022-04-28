package com.mall.api.controller;

import com.mall.api.annotation.Login;
import com.mall.api.annotation.LoginUser;
import com.mall.api.dto.request.BuyNowDto;
import com.mall.api.dto.request.OrderDataDto;
import com.mall.api.service.OrderService;
import com.mall.core.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Login
    @GetMapping("/list")
    public Object orderList(@LoginUser Integer uid) {
        return ResponseUtil.ok(orderService.list(uid));
    }

    @Login
    @GetMapping("/recent")
    public Object recentOrder(@LoginUser Integer uid) {
        return ResponseUtil.ok(orderService.getRecentOrder(uid));
    }


    @Login
    @PostMapping("/buyNow")
    public Object create(
            @LoginUser Integer uid,
            @RequestBody @Validated BuyNowDto dto
    ) {
        return orderService.buyNow(uid, dto);
    }

    @Login
    @PostMapping("/cart/buyNow")
    public Object createByCart(
            @LoginUser Integer uid,
            @RequestBody @Validated List<Integer> ids
    ) {
        if (ids == null || ids.size() == 0) {
            return ResponseUtil.fail("请选择商品!");
        }
        return orderService.buyNowFromCart(uid, ids);
    }

    @Login
    @GetMapping("/cart/cancel/{oid}/{cid}")
    public Object cancel(
            @LoginUser Integer uid,
            @PathVariable() Integer oid,
            @PathVariable() Integer cid
    ) {
        return orderService.cancel(uid, oid, cid);
    }

    @Login
    @GetMapping("/cart/complete/{oid}/{cid}")
    public Object complete(
            @LoginUser Integer uid,
            @PathVariable() Integer oid,
            @PathVariable() Integer cid
    ) {
        return orderService.complete(uid, oid, cid);
    }

}
