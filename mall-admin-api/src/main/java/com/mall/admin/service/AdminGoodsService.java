package com.mall.admin.service;


import com.github.pagehelper.PageInfo;
import com.mall.db.domain.Goods;
import com.mall.db.exception.ServiceBadArgumentException;
import com.mall.db.service.GoodsBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminGoodsService {

    @Autowired
    private GoodsBaseService goodsBaseService;


    public Map<String, Object> list(Integer currentPageNum, Integer pageSize, String type, String key) {
        List<Goods> goods = goodsBaseService.querySelectiveSimple(currentPageNum, pageSize, type, key);
        long total = PageInfo.of(goods).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("list", goods);

        return data;
    }

    public boolean changeState(Integer id, Boolean status) {
        if (null == id || null == status || null == goodsBaseService.findById(id)) {
            throw new ServiceBadArgumentException("参数错误!");
        }

        Goods goods = new Goods();
        goods.setId(id);
        goods.setStatus(status);

        return goodsBaseService.updateSelective(goods);
    }
}
