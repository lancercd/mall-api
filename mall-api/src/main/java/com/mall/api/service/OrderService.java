package com.mall.api.service;

import com.mall.db.domain.Order;
import com.mall.db.domain.OrderExample;
import com.mall.db.service.GoodsBaseService;
import com.mall.db.service.OrderBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderBaseService orderBaseService;

    public List<Order> getRecentOrder() {
        OrderExample example = new OrderExample();
        example.orderBy(Order.Column.addTime.desc());
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo((short)-1);
        return orderBaseService.queryByExample(1, 3, example);
    }

}
