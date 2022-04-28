package com.mall.api.dto.response;

import com.mall.db.domain.Cart;
import com.mall.db.domain.Goods;
import com.mall.db.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderWithDetailDto extends Order {
    List<CartDto> carts;

    public static OrderWithDetailDto convert(Order order, List<CartDto> carts) {
        OrderWithDetailDto dto = new OrderWithDetailDto();
        dto.setCarts(carts);
        dto.setId(order.getId());
        dto.setUid(order.getUid());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setStatus(order.getStatus());
        dto.setAddTime(order.getAddTime());
        dto.setFinishTime(order.getFinishTime());
        return dto;
    }
}
