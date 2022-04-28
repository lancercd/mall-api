package com.mall.admin.service;


import com.mall.admin.dto.CartDto;
import com.mall.db.domain.Cart;
import com.mall.db.domain.Goods;
import com.mall.db.service.CartBaseService;
import com.mall.db.service.GoodsBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminCartService {

    @Autowired
    private GoodsBaseService goodsBaseService;

    @Autowired
    private AdminGoodsService adminGoodsService;

    @Autowired
    private CartBaseService cartBaseService;

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
