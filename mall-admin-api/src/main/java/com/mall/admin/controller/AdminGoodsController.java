package com.mall.admin.controller;


import com.mall.admin.service.AdminGoodsService;
import com.mall.core.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/goods")
public class AdminGoodsController {

    @Autowired
    private AdminGoodsService adminGoodsService;


    @GetMapping("/list")
    public Object goodsList(
            @RequestParam(defaultValue = "1") Integer currentPageNum,
            @RequestParam(defaultValue = "10")Integer pageSize,
            @RequestParam(defaultValue = "name")String type,
            @RequestParam(defaultValue = "")String key
    ) {
        if (null != key) key = key.trim();
        Map<String, Object> list = adminGoodsService.list(currentPageNum, pageSize, type, key);
        return ResponseUtil.ok(list);
    }


    @GetMapping("/change/status")
    public Object changeState(@RequestParam Integer id, @RequestParam Boolean status) {
        adminGoodsService.changeState(id, status);
        return ResponseUtil.ok();
    }

}
