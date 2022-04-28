package com.mall.api.dto.response;

import com.mall.db.domain.Cart;
import com.mall.db.domain.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto extends Cart {

    private Goods goods;

    public static CartDto convert(Cart cart, Goods goods) {
        CartDto dto = new CartDto();
        dto.setGoods(goods);
        dto.setId(cart.getId());
        dto.setUid(cart.getUid());
        dto.setOrderId(cart.getOrderId());
        dto.setGoodsId(cart.getGoodsId());
        dto.setPrice(cart.getPrice());
        dto.setNum(cart.getNum());
        dto.setStatus(cart.getStatus());
        dto.setBuyTime(cart.getBuyTime());
        dto.setAddTime(cart.getAddTime());
        return dto;
    }
}
