package com.mall.admin.service;

import com.github.pagehelper.PageInfo;
import com.mall.db.domain.User;
import com.mall.db.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminUserService {

    @Autowired
    private UserBaseService userBaseService;

    public Map<String, Object> list(Integer page, Integer size, String keywords, String order) {
        List<User> users = userBaseService.querySelective(page, size, "username", keywords);
        long total = PageInfo.of(users).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("list", users);
        return data;
    }

}
