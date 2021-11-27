package com.mall.db.service;


import com.mall.db.dao.AdminMapper;
import com.mall.db.domain.Admin;
import com.mall.db.domain.AdminExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminBaseService extends BaseService {

    @Resource
    private AdminMapper adminMapper;

    public Admin findById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    public Admin findByUsername(String username) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);

        return adminMapper.selectOneByExample(example);
    }
}
