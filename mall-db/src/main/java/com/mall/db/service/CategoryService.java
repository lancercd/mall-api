package com.mall.db.service;

import com.mall.db.dao.MallUserMapper;
import com.mall.db.domain.MallUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MallUserService {

    @Resource
    private MallUserMapper mallAdMapper;

    public MallUser findById(Integer id) {
        return mallAdMapper.selectByPrimaryKey(id);
    }
}
