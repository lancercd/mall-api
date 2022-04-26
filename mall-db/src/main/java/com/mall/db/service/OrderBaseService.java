package com.mall.db.service;

import com.github.pagehelper.PageHelper;
import com.mall.db.dao.CategoryMapper;
import com.mall.db.dao.OrderMapper;
import com.mall.db.domain.*;
import com.mall.db.exception.ServiceBadArgumentException;
import com.mall.db.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
