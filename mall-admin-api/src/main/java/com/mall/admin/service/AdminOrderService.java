package com.mall.admin.service;

import com.github.pagehelper.PageInfo;
import com.mall.admin.dto.OrderWithDetailDto;
import com.mall.db.domain.Goods;
import com.mall.db.domain.Order;
import com.mall.db.service.CartBaseService;
import com.mall.db.service.OrderBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminOrderService {

    @Autowired
    private OrderBaseService orderBaseService;

    @Autowired
    private CartBaseService cartBaseService;

    @Autowired
    private AdminCartService adminCartService;

    public Map<String, Long> countInfo() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("all", orderBaseService.count());
        map.put("active", orderBaseService.countActive());
        return map;
    }

    public Map<String, Object> list(Integer currentPageNum, Integer pageSize, String type, String key) {
        List<Order> orders = orderBaseService.querySelective(currentPageNum, pageSize, type, key);
        List<OrderWithDetailDto> list = new ArrayList<>(orders.size());
        for (Order order : orders) {
            list.add(OrderWithDetailDto.convert(order, adminCartService.findByOrderId(order.getId())));
        }

        long total = PageInfo.of(orders).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("list", list);

        return data;
    }

}
