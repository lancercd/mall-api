package com.mall.db.service;

import com.github.pagehelper.PageHelper;
import com.mall.db.dao.OrderMapper;
import com.mall.db.domain.*;
import com.mall.db.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderBaseService extends BaseService {

    @Resource
    private OrderMapper orderMapper;

    public Order findById(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    public List<Order> queryByExample(Integer currentPageNum, Integer pageSize, OrderExample example) {
        PageHelper.startPage(currentPageNum, pageSize);
        return orderMapper.selectByExampleSelective(example);
    }

    public int addSelective(Order order) {
        order.setAddTime(LocalDateTime.now());
        return orderMapper.insertSelective(order);
    }

    public boolean updateByIdSelective(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order) != 0;
    }

    public long count() {
        OrderExample example = new OrderExample();
        return orderMapper.countByExample(example);
    }

    public long countActive() {
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();

        criteria.andAddTimeGreaterThan(LocalDateTime.now().minusDays(1));

        return orderMapper.countByExample(example);
    }

    public List<Order> querySelective(Integer currentPageNum, Integer pageSize, String type, String key) {
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();

        // if (!StringUtil.isEmpty(type)) {
        //     if (Goods.Column.name.value().equals(type)) {
        //         criteria.andNameLike('%' + key + '%');
        //     } else if (Goods.Column.description.value().equals(type)) {
        //         // criteria.andDescriptionLike('%' + key + '%');
        //     }
        // }

        example.orderBy(Goods.Column.addTime.desc());

        PageHelper.startPage(currentPageNum, pageSize);

        return orderMapper.selectByExampleSelective(example);
    }
}
