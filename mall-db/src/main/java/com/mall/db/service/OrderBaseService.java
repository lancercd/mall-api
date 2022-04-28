package com.mall.db.service;

import com.github.pagehelper.PageHelper;
import com.mall.db.dao.OrderMapper;
import com.mall.db.domain.*;
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
}
