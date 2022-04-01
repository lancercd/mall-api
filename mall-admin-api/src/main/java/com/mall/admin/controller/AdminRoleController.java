package com.mall.admin.controller;


import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.Role;
import com.mall.db.service.RoleBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/role")
public class AdminRoleController {

    @Autowired
    private RoleBaseService roleBaseService;


    @PostMapping("/list")
    public Object getList() {
        List<Role> data = roleBaseService.getList();
        return ResponseUtil.ok(data);
    }

    @PostMapping("/add")
    public Object add(@RequestBody Role role) {

        boolean res = roleBaseService.add(role);
        if(!res) {
            return ResponseUtil.fail("添加失败!");
        }
        return ResponseUtil.ok();
    }

    @PostMapping("/modify")
    public Object modify(@RequestBody Role role) {

        boolean res = roleBaseService.modify(role);
        if(!res) {
            return ResponseUtil.fail("修改失败!");
        }
        return ResponseUtil.ok();
    }


}
