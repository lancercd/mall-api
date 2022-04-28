package com.mall.api.service;

import com.mall.api.dto.request.BuyNowDto;
import com.mall.api.dto.request.OrderDataDto;
import com.mall.api.dto.response.CartDto;
import com.mall.api.dto.response.OrderWithDetailDto;
import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.Cart;
import com.mall.db.domain.Goods;
import com.mall.db.domain.Order;
import com.mall.db.domain.OrderExample;
import com.mall.db.service.CartBaseService;
import com.mall.db.service.GoodsBaseService;
import com.mall.db.service.OrderBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderBaseService orderBaseService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartBaseService cartBaseService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsBaseService goodsBaseService;

    public List<OrderWithDetailDto> list(Integer uid) {
        OrderExample example = new OrderExample();
        example.orderBy(Order.Column.addTime.desc());
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        List<Order> orders = orderBaseService.queryByExample(1, 200, example);
        List<OrderWithDetailDto> list = new ArrayList<>(orders.size());
        for (Order order : orders) {
            list.add(OrderWithDetailDto.convert(order, cartService.findByOrderId(order.getId())));
        }
        return list;
    }


    public List<OrderWithDetailDto> getRecentOrder(Integer uid) {
        OrderExample example = new OrderExample();
        example.orderBy(Order.Column.addTime.desc());
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo((short)-1);
        criteria.andUidEqualTo(uid);
        List<Order> orders = orderBaseService.queryByExample(1, 3, example);
        List<OrderWithDetailDto> list = new ArrayList<>(orders.size());
        for (Order order : orders) {
            list.add(OrderWithDetailDto.convert(order, cartService.findByOrderId(order.getId())));
        }
        return list;
    }

    public Object buyNow(Integer uid, BuyNowDto dto) {
        Goods goods = goodsBaseService.findById(dto.getGoodsId());
        Integer num = dto.getNum();

        String checkInfo = goodsService.isAvailable(goods, num);
        if (checkInfo != null) {
            return ResponseUtil.fail(checkInfo);
        }

        if (goods.getUid().equals(uid)) {
            return ResponseUtil.fail("无法购买自己发布的商品!");
        }

        Order order = createOrder(uid, cartService.calculatePrice(goods, num));

        if (cartService.createWithBuy(goods, order.getId(), uid, num) == 0) {
            return ResponseUtil.fail("购买失败!");
        }

        return ResponseUtil.okMsg("购买成功");
    }

    public Object buyNowFromCart(Integer uid, List<Integer> ids) {
        List<CartDto> carts = cartService.findByIds(uid, ids);
        BigDecimal totalPrice = BigDecimal.valueOf(0);

        // check 商品是否可被购买 & 计算价格
        for (CartDto cart : carts) {

            Integer num = cart.getNum();
            Goods goods = cart.getGoods();
            String checkInfo = goodsService.isAvailable(cart.getGoods(), num);
            if (checkInfo != null) {
                return ResponseUtil.fail(checkInfo);
            }

            totalPrice = totalPrice.add(cartService.calculatePrice(goods, num));
        }

        Order order = createOrder(uid, totalPrice);

        if (cartService.createFromCart(uid, order.getId(), ids) == 0) {
            return ResponseUtil.fail("购买失败!");
        }

        return ResponseUtil.okMsg("购买成功!");
    }

    private Order createOrder(Integer uid, BigDecimal totalPrice) {
        Order order = new Order();
        order.setUid(uid);
        order.setStatus((short)0);
        order.setTotalPrice(totalPrice);
        orderBaseService.addSelective(order);
        return order;
    }

    public Object cancel(Integer uid, Integer oid, Integer cid) {
        Order order = orderBaseService.findById(oid);
        List<Cart> carts = cartService.findByOrderId(uid, oid);

        if (carts == null) {
            return ResponseUtil.fail("不存在!");
        }

        boolean isSuccess = false;
        boolean isAllCancel = true;
        Cart needCancelCart = null;

        int len = carts.size();
        if (len == 1) {
            Cart cart = carts.get(0);
            if (!cart.getId().equals(cid)) {
                return ResponseUtil.fail("不存在!");
            }
            needCancelCart = cart;
        } else {
            for (Cart cart : carts) {
                if (cart.getId().equals(cid)) {
                    needCancelCart = cart;
                } else if (cart.getStatus() != -1) {
                    isAllCancel = false;
                }
            }
        }

        if (needCancelCart != null) {
            needCancelCart.setStatus((byte) -1);
            isSuccess = cartBaseService.update(needCancelCart);
        } else {
            return ResponseUtil.fail("不存在!");
        }


        if (isAllCancel) {
            order.setStatus((short) -1);
            orderBaseService.updateByIdSelective(order);
        }

        if (!isSuccess) {
            return ResponseUtil.fail("失败!");
        }
        return ResponseUtil.ok();
    }

    public Object complete(Integer uid, Integer oid, Integer cid) {
        Order order = orderBaseService.findById(oid);
        List<Cart> carts = cartService.findByOrderId(uid, oid);

        if (carts == null) {
            return ResponseUtil.fail("不存在!");
        }

        boolean isSuccess = false;
        boolean isAllComplete = true;
        Cart needCompleteCart = null;

        int len = carts.size();
        if (len == 1) {
            Cart cart = carts.get(0);
            if (!cart.getId().equals(cid)) {
                return ResponseUtil.fail("不存在!");
            }
            needCompleteCart = cart;
        } else {
            for (Cart cart : carts) {
                if (cart.getId().equals(cid)) {
                    needCompleteCart = cart;
                } else if (cart.getStatus() == 1) {
                    isAllComplete = false;
                }
            }
        }

        if (needCompleteCart != null) {
            needCompleteCart.setStatus((byte) 2);
            isSuccess = cartBaseService.update(needCompleteCart);
        } else {
            return ResponseUtil.fail("不存在!");
        }

        if (isAllComplete) {
            order.setStatus((short) 1);
            orderBaseService.updateByIdSelective(order);
        }

        if (!isSuccess) {
            return ResponseUtil.fail("失败!");
        }
        return ResponseUtil.ok();
    }

}
