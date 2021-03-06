package com.mall.api.controller;

import com.mall.api.annotation.Login;
import com.mall.api.annotation.LoginUser;
import com.mall.api.dto.request.IdsDto;
import com.mall.api.service.CartService;
import com.mall.api.service.GoodsService;
import com.mall.core.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CartService cartService;

    @Login
    @GetMapping("/list")
    public Object list(@LoginUser Integer uid) {
        return ResponseUtil.ok(cartService.list(uid));
    }

    @Login
    @GetMapping("/add/{id}/{num}")
    public Object add(@LoginUser Integer uid, @PathVariable() Integer id, @PathVariable() Integer num) {
        return cartService.add(uid, id, num);
    }

    @Login
    @PostMapping("/del")
    public Object add(@LoginUser Integer uid, @RequestBody IdsDto idsDto) {
        List<Integer> ids = idsDto.getIds();
        if (ids.size() == 0) {
            return ResponseUtil.fail("请选择商品!");
        }
        return cartService.del(uid, idsDto.getIds());
    }
}
