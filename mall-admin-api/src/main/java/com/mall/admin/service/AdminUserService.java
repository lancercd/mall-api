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

    public Map<String, Object> list(
            Integer page,
            Integer size,
            Integer status,
            String type,
            String keywords) {
        List<User> users = userBaseService.querySelective(page, size, status, type, keywords);
        long total = PageInfo.of(users).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("list", users);
        return data;
    }

    public Map<String, Long> countInfo() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("all", userBaseService.count());
        map.put("active", userBaseService.countActive());

        return map;
    }

    public boolean removeFromBlackList(Integer uid) {
        User user = userBaseService.findById(uid);
        user.setStatus((byte) 0);
        return userBaseService.updateByPrimaryKeySelective(user);
    }

    public boolean addFromBlackList(Integer uid) {
        User user = userBaseService.findById(uid);
        user.setStatus((byte) 1);
        return userBaseService.updateByPrimaryKeySelective(user);
    }
}
