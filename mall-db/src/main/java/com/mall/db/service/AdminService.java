package com.mall.db.service;


import com.mall.db.dao.AdminMapper;
import com.mall.db.domain.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    public Admin findById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}
