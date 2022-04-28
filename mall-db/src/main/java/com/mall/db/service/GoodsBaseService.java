package com.mall.db.service;


import com.github.pagehelper.PageHelper;
import com.mall.db.dao.GoodsMapper;
import com.mall.db.domain.Goods;
import com.mall.db.domain.Goods.Column;
import com.mall.db.domain.GoodsExample;
import com.mall.db.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GoodsBaseService extends BaseService {

    @Resource
    private GoodsMapper goodsMapper;

    Column[] list = new Column[]{
            Column.id,
            Column.name,
            Column.description,
            Column.price,
            Column.categoryId,
            Column.status
    };


    public Goods findById(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    public List<Goods> querySelectiveSimple(Integer currentPageNum, Integer pageSize, String type, String key) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();

        if (!StringUtil.isEmpty(type)) {
            if (Column.name.value().equals(type)) {
                criteria.andNameLike('%' + key + '%');
            } else if (Column.description.value().equals(type)) {
                // criteria.andDescriptionLike('%' + key + '%');
            }
        }

        example.orderBy(Column.addTime.desc());

        PageHelper.startPage(currentPageNum, pageSize);

        return goodsMapper.selectByExampleSelective(example, list);
    }

    public List<Goods> querySelective(Integer currentPageNum, Integer pageSize, String type, String key) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();

        if (!StringUtil.isEmpty(type)) {
            if (Column.name.value().equals(type)) {
                criteria.andNameLike('%' + key + '%');
            } else if (Column.description.value().equals(type)) {
                // criteria.andDescriptionLike('%' + key + '%');
            }
        }

        example.orderBy(Column.addTime.desc());

        PageHelper.startPage(currentPageNum, pageSize);

        return goodsMapper.selectByExampleSelective(example);
    }

    public boolean update(Goods goods) {
        return goodsMapper.updateByPrimaryKey(goods) == 1;
    }

    public boolean add(Goods goods) {
        goods.setAddTime(LocalDateTime.now());
        return goodsMapper.insertSelective(goods) == 1;
    }

    public boolean addSelective(Goods goods) {
        goods.setAddTime(LocalDateTime.now());
        return goodsMapper.insertSelective(goods) == 1;
    }

    public boolean updateSelective(Goods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods) == 1;
    }

    public List<Goods> queryByExampleAndPage(Integer currentPageNum, Integer pageSize, GoodsExample example) {
        PageHelper.startPage(currentPageNum, pageSize);
        return goodsMapper.selectByExampleSelective(example);
    }

    public List<Goods> queryByExample(GoodsExample example) {
        return goodsMapper.selectByExampleSelective(example);
    }

}
