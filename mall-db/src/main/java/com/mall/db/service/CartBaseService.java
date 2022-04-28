package com.mall.db.service;

import com.github.pagehelper.PageHelper;
import com.mall.db.dao.CartMapper;
import com.mall.db.dao.CategoryMapper;
import com.mall.db.domain.*;
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

    public List<Cart> findByUid(Integer uid) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        return cartMapper.selectByExampleSelective(example);
    }

    public boolean del(Integer id) {
        return cartMapper.deleteByPrimaryKey(id) != 0;
    }

    public boolean delByIds(List<Integer> ids) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return cartMapper.deleteByExample(example) != 0;
    }

    public boolean delByIdsAndUid(Integer uid, List<Integer> ids) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        criteria.andUidEqualTo(uid);
        return cartMapper.deleteByExample(example) != 0;
    }


    public Cart findByUidAndGoodsId(Integer uid, Integer goodsId) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andGoodsIdEqualTo(goodsId);

        return cartMapper.selectOneByExampleSelective(example);
    }

    public List<Cart> findByOrderId(Integer orderId) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        return cartMapper.selectByExample(example);
    }

    public Cart findByStatus(Integer uid, Integer goodsId, int status) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andGoodsIdEqualTo(goodsId);
        criteria.andStatusEqualTo((byte) status);
        return cartMapper.selectOneByExampleSelective(example);
    }

    public boolean add(Cart cart) {
        cart.setAddTime(LocalDateTime.now());
        return cartMapper.insertSelective(cart) == 1;
    }

    public int insertSelective(Cart cart) {
        cart.setAddTime(LocalDateTime.now());
        return cartMapper.insertSelective(cart);
    }

    public int insert(Cart cart) {
        return cartMapper.insert(cart);
    }

    public boolean updateSelective(Cart cart) {
        return cartMapper.updateByPrimaryKeySelective(cart) == 1;
    }

    public boolean update(Cart cart) {
        return cartMapper.updateByPrimaryKey(cart) == 1;
    }

    public List<Cart> getList() {
        CartExample example = new CartExample();
        example.orderBy(Cart.Column.addTime.desc());
        // CategoryExample.Criteria criteria = example.createCriteria();
        // criteria.andIdEqualTo(1);
        return cartMapper.selectByExample(example);
    }

    public List<Cart> queryByExample(CartExample example) {
        return cartMapper.selectByExampleSelective(example);
    }

    public int updateByExample(Cart cart, CartExample example) {
        return cartMapper.updateByExampleSelective(cart, example);
    }
}
