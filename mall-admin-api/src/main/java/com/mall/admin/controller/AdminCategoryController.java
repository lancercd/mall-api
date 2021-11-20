package com.mall.admin.controller;


import com.mall.core.utils.ResponseUtil;
import com.mall.db.utils.StringUtil;
import com.mall.db.domain.Category;
import com.mall.db.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/list")
    public Object getList() {
        List<Category> data = categoryService.getList();
        return ResponseUtil.ok(data);
    }

    @PostMapping("/add")
    public Object add(Category category) {
        // String name = body.get("name");
        // System.out.println(name);
        System.out.println(category);

        // if (!StringUtil.isEmpty(category.getName())) {
        //     return ResponseUtil.badArgument("分类名称不能为空!");
        // }

        boolean res = categoryService.add(category);
        if(!res) {
            return ResponseUtil.fail("添加失败!");
        }
        return ResponseUtil.ok();
    }

}
