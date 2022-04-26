package com.mall.api.service;


import com.github.pagehelper.PageInfo;
import com.mall.db.domain.Goods;
import com.mall.db.domain.GoodsExample;
import com.mall.db.service.GoodsBaseService;
import com.mall.db.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService {

    @Autowired
    private GoodsBaseService goodsBaseService;

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
}
