package com.mall.db.service;

import com.mall.db.dao.CartMapper;
import com.mall.db.dao.CategoryMapper;
import com.mall.db.domain.Cart;
import com.mall.db.domain.CartExample;
import com.mall.db.domain.Category;
import com.mall.db.domain.CategoryExample;
import com.mall.db.exception.ServiceBadArgumentException;
import com.mall.db.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartBaseService extends BaseService {

    @Resource
    private CartMapper cartMapper;

    public Cart findById(Integer id) {
        return cartMapper.selectByPrimaryKey(id);
    }

    public boolean add(Cart cart) {
        cart.setAddTime(LocalDateTime.now());
        return cartMapper.insertSelective(cart) == 1;
    }


    public List<Cart> getList() {
        CartExample example = new CartExample();
        example.orderBy(Cart.Column.addTime.desc());
        // CategoryExample.Criteria criteria = example.createCriteria();
        // criteria.andIdEqualTo(1);
        return cartMapper.selectByExample(example);
    }
}
