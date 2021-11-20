package com.mall.db.service;


import com.mall.db.dao.GoodsMapper;
import com.mall.db.domain.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    public Goods findById(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

}
