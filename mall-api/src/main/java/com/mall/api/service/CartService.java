package com.mall.api.service;


import com.mall.api.dto.response.CartDto;
import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.Cart;
import com.mall.db.domain.CartExample;
import com.mall.db.domain.Goods;
import com.mall.db.service.CartBaseService;
import com.mall.db.service.GoodsBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private GoodsBaseService goodsBaseService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CartBaseService cartBaseService;

    public List<CartDto> findByIds(Integer uid, List<Integer> ids) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        criteria.andUidEqualTo(uid);

        List<Cart> carts = cartBaseService.queryByExample(example);
        List<CartDto> list = new ArrayList<>(carts.size());
        for (Cart cart : carts) {
            Goods goods = goodsBaseService.findById(cart.getGoodsId());
            list.add(CartDto.convert(cart, goods));
        }
        return list;
    }

    public List<Cart> findByOrderId(Integer uid, Integer oid) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(oid);
        criteria.andUidEqualTo(uid);
        return cartBaseService.queryByExample(example);
    }

    public List<CartDto> list(Integer uid) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andStatusEqualTo((byte)0);

        List<Cart> carts = cartBaseService.queryByExample(example);
        int len = carts.size();

        List<CartDto> list = new ArrayList<>(len);

        for (Cart cart : carts) {
            Goods goods = goodsBaseService.findById(cart.getGoodsId());
            list.add(CartDto.convert(cart, goods));
        }

        return list;
    }

    public Object add(Integer uid, Integer id, Integer num) {
        Goods goods = goodsBaseService.findById(id);

        String checkInfo = goodsService.isAvailable(goods, num);
        if (checkInfo != null) {
            return ResponseUtil.fail(checkInfo);
        }

        if (goods.getUid().equals(uid)) {
            return ResponseUtil.fail("无法添加自己发布的商品到购物车!");
        }

        Cart cart = cartBaseService.findByStatus(uid, goods.getId(), 0);

        if (null != cart) {
            // 修改g购物车的数量
            if (cart.getNum().equals(num)) {
                return ResponseUtil.fail("已经添加过购物车了!");
            } else {
                return modCart(cart, goods, num);
            }
        } else {
            return createCart(goods, uid, num);
        }
    }

    public int createWithBuy(Goods goods, Integer orderId, Integer uid, Integer num) {
        Cart cart = new Cart();
        cart.setUid(uid);
        cart.setOrderId(orderId);
        cart.setGoodsId(goods.getId());
        cart.setNum(num);
        cart.setPrice(calculatePrice(goods, num));
        cart.setStatus((byte)1);
        cart.setBuyTime(LocalDateTime.now());
        return cartBaseService.insertSelective(cart);
    }

    public int createFromCart(Integer uid, Integer orderId, List<Integer> cartIds) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria
            .andIdIn(cartIds)
            .andUidEqualTo(uid);

        Cart cart = new Cart();
        cart.setOrderId(orderId);
        cart.setStatus((byte) 1);
        return cartBaseService.updateByExample(cart, example);
    }

    private Object createCart(Goods goods, Integer uid, Integer num) {
        Cart cart = new Cart();
        cart.setUid(uid);
        cart.setGoodsId(goods.getId());
        cart.setNum(num);
        cart.setPrice(calculatePrice(goods, num));
        if (!cartBaseService.add(cart)) {
            return ResponseUtil.fail("添加失败!");
        }
        return ResponseUtil.okMsg("添加成功!");
    }

    private Object modCart(Cart cart, Goods goods, Integer num) {
        cart.setNum(num);
        cart.setPrice(goods.getPrice().multiply(BigDecimal.valueOf(num)));
        if (!cartBaseService.update(cart)) {
            return ResponseUtil.fail("修改失败!");
        }
        return ResponseUtil.okMsg("修改成功!");
    }

    public Object del(Integer uid, List<Integer> ids) {
        if (cartBaseService.delByIdsAndUid(uid, ids)) {
            return ResponseUtil.okMsg("删除成功!");
        } else {
            return ResponseUtil.fail("删除失败!");
        }
    }

    public BigDecimal calculatePrice(Goods goods, Integer num) {
        if (num == null) {
            num = 1;
        }
        return goods.getPrice().multiply(BigDecimal.valueOf(num));
    }

    public List<CartDto> findByOrderId(Integer orderId){
        List<Cart> carts = cartBaseService.findByOrderId(orderId);
        List<CartDto> list = new ArrayList<>(carts.size());
        for (Cart cart : carts) {
            Goods goods = goodsBaseService.findById(cart.getGoodsId());
            list.add(CartDto.convert(cart, goods));
        }
        return list;
    }

}
