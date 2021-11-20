package com.mall.db.service;

import com.mall.db.dao.MallAdMapper;
import com.mall.db.domain.MallAd;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MallAdService {

    @Resource
    private MallAdMapper mallAdMapper;

    public MallAd findById(Integer id) {
        return mallAdMapper.selectByPrimaryKey(id);
    }
}
