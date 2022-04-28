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
            @RequestParam(defaultValue = "0")Integer status,
            @RequestParam(defaultValue = "username")String type,
            @RequestParam(defaultValue = "")String key
    ) {
        if (null != key) key = key.trim();
        Map<String, Object> list = adminUserService.list(currentPageNum, pageSize, status, type, key);
        return ResponseUtil.ok(list);
    }

    @GetMapping("/remove/from/black")
    public Object removeFromBlackList(Integer uid) {
        if(!adminUserService.removeFromBlackList(uid)) {
            return ResponseUtil.fail("恢复失败");
        }
        return ResponseUtil.ok();
    }

    @GetMapping("/add/from/black")
    public Object addFromBlackList(Integer uid) {
        if(!adminUserService.addFromBlackList(uid)) {
            return ResponseUtil.fail("恢复失败");
        }
        return ResponseUtil.ok();
    }

}
