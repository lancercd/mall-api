package com.mall.db.service;


import com.mall.db.dao.GoodsMapper;
import com.mall.db.domain.Goods;
import com.mall.db.domain.GoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    public Goods findById(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    public List<Goods> getList(Integer currentPageNum, Integer pageSize, String type, String key) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();

        if (null != type) {
            if ("name".equals(type)) {
                criteria.andNameLike('%' + key + '%');
            } else if ("description".equals(type)) {
                criteria.andDescriptionLike('%' + key + '%');
            }
        }

        return goodsMapper.selectByExample(example);
    }

}
