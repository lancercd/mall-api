package com.mall.api.controller;

import com.mall.api.dto.request.UserLoginAndRegister;
import com.mall.api.service.GoodsService;
import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.Goods;
import com.mall.db.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.Map;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public Object goodsList(
            @RequestParam(defaultValue = "1") Integer currentPageNum,
            @RequestParam(defaultValue = "10")Integer pageSize,
            @RequestParam(defaultValue = "")String key,
            @RequestParam(defaultValue = "")String filed,
            @RequestParam(defaultValue = "")String order
    ) {
        Map<String, Object> list = goodsService.list(currentPageNum, pageSize, key, filed, order);
        return ResponseUtil.ok(list);
    }

    @PostMapping("/add")
    public Object add(
            @RequestBody Goods goods
    ) {
        goodsService.add(goods);
        return ResponseUtil.ok();
    }
}
