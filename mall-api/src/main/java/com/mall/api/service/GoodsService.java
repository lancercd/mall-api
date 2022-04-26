package com.mall.api.service;


import com.github.pagehelper.PageInfo;
import com.mall.api.dto.request.UserLoginAndRegister;
import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.Cart;
import com.mall.db.domain.Goods;
import com.mall.db.domain.GoodsExample;
import com.mall.db.domain.User;
import com.mall.db.service.CartBaseService;
import com.mall.db.service.GoodsBaseService;
import com.mall.db.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService {

    @Autowired
    private GoodsBaseService goodsBaseService;

    @Autowired
    private CartBaseService cartBaseService;

    public Map<String, Object> list(Integer currentPageNum, Integer pageSize, String key, String filed, String order) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();

        if (!StringUtil.isEmpty(filed)) {
            String orderBy = "`" + filed + "`";
            if (!StringUtil.isEmpty(order)) {
                orderBy += order;
            }
            example.orderBy(orderBy);
        }

        if (!StringUtil.isEmpty(key)) {
            criteria.andNameLike("%" + key + "%");
        }

        List<Goods> goods = goodsBaseService.queryByExample(currentPageNum, pageSize, example);
        long total = PageInfo.of(goods).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("list", goods);

        return data;
    }

    public Goods detail(Integer id) {
        return goodsBaseService.findById(id);
    }

    public void add(Goods goods) {
        goods.setIsOnSale((byte)1);
        goods.setType((byte)0);
        goods.setStatus((byte)1);
        goods.setDegreeId((byte)0);
        goodsBaseService.add(goods);
    }

    public Object addToCart(Integer uid, Integer id, Integer num) {
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

        Cart cart = new Cart();
        cart.setUid(uid);
        cart.setGoodsId(id);
        cart.setNum(num);
        cart.setPrice(goods.getPrice().multiply(BigDecimal.valueOf(num)));
        if (!cartBaseService.add(cart)) {
            return ResponseUtil.fail("添加失败!");
        }
        return ResponseUtil.fail("添加成功!");
    }
}
