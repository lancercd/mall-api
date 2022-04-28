package com.mall.admin.service;

import com.github.pagehelper.PageInfo;
import com.mall.db.domain.Banner;
import com.mall.db.domain.User;
import com.mall.db.service.BannerBaseService;
import com.mall.db.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminSettingService {

    @Autowired
    private BannerBaseService bannerBaseService;

    public Map<String, Object> bannerList() {
        List<Banner> users = bannerBaseService.querySelective();
        long total = PageInfo.of(users).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("list", users);
        return data;
    }
}
