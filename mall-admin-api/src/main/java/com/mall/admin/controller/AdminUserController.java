package com.mall.admin.controller;

import com.mall.admin.service.AdminUserService;
import com.mall.core.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Validated
@RestController
@RequestMapping("/api/admin/user")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;


    @GetMapping("/list")
    public Object goodsList(
            @RequestParam(defaultValue = "1") Integer currentPageNum,
            @RequestParam(defaultValue = "10")Integer pageSize,
            @RequestParam(defaultValue = "username")String type,
            @RequestParam(defaultValue = "")String key
    ) {
        if (null != key) key = key.trim();
        Map<String, Object> list = adminUserService.list(currentPageNum, pageSize, type, key);
        return ResponseUtil.ok(list);
    }

}
