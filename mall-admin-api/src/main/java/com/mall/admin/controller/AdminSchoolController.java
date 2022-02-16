package com.mall.admin.controller;

import com.alibaba.druid.util.StringUtils;
import com.mall.admin.service.AdminSchoolService;
import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.School;
import org.springframework.beans.factory.annotation.Autowired;
import com.mall.core.validator.Order;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/admin/school")
public class AdminSchoolController {

    @Autowired
    private AdminSchoolService adminSchoolService;

    @GetMapping("/list")
    public Object list(
            String keywords,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @Order @RequestParam(defaultValue = "ASC") String order
    ) {
        List<School> lists = adminSchoolService.queryList(keywords, page, size, order);

        return ResponseUtil.pagination(lists);
    }

    @GetMapping("/add")
    public Object add(String name) {
        if (StringUtils.isEmpty(name)) {
            return ResponseUtil.fail("名称不能为空!");
        }
        return adminSchoolService.add(name);
    }

    @GetMapping("/del")
    public Object del(Integer id) {
        if (null == id) {
            return ResponseUtil.fail("id不能为空!");
        }
        return adminSchoolService.del(id);
    }

}
