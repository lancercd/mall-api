package com.mall.admin.controller;


import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.Category;
import com.mall.db.service.CategoryBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class AdminCategoryController {

    @Autowired
    private CategoryBaseService categoryBaseService;


    @PostMapping("/list")
    public Object getList() {
        List<Category> data = categoryBaseService.getList();
        return ResponseUtil.ok(data);
    }

    @PostMapping("/add")
    public Object add(@RequestBody Category category) {

        boolean res = categoryBaseService.add(category);
        if(!res) {
            return ResponseUtil.fail("添加失败!");
        }
        return ResponseUtil.ok();
    }

    @PostMapping("/modify")
    public Object modify(@RequestBody Category category) {
        System.out.println(category);

        boolean res = categoryBaseService.modify(category);
        if(!res) {
            return ResponseUtil.fail("修改失败!");
        }
        return ResponseUtil.ok();
    }


}
