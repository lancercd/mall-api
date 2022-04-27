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
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private GoodsBaseService goodsBaseService;

    @Autowired
    private CartBaseService cartBaseService;

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

        if (null == goods) {
            return ResponseUtil.fail("商品不存在!");
        }

        if (0 == goods.getStatus()) {
            return ResponseUtil.fail("商品下架无法添加!");
        }

        if (1 != goods.getIsOnSale()) {
            return ResponseUtil.fail("商品审核未通过!");
        }

        Integer quantity = goods.getQuantity();

        if (quantity <= 0) {
            return ResponseUtil.fail("商品已售空!");
        }

        if (quantity < num) {
            return ResponseUtil.fail("商品数量只剩" + quantity + "个, 请修改数量");
        }

        Cart cart = cartBaseService.findByUidAndGoodsId(uid, goods.getId());

        if (null != cart && cart.getStatus() == 0) {
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

    private Object createCart(Goods goods, Integer uid, Integer num) {
        Cart cart = new Cart();
        cart.setUid(uid);
        cart.setGoodsId(goods.getId());
        cart.setNum(num);
        cart.setPrice(goods.getPrice().multiply(BigDecimal.valueOf(num)));
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
}
