package com.mall.api.service;


import com.github.pagehelper.PageInfo;
import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.Goods;
import com.mall.db.domain.GoodsExample;
import com.mall.db.service.GoodsBaseService;
import com.mall.db.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService {

    @Autowired
    private GoodsBaseService goodsBaseService;

    public Map<String, Object> list(
            Integer currentPageNum,
            Integer pageSize,
            String key,
            Integer categoryId,
            Integer schoolId,
            String filed, String order
    ) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();

        if (!StringUtil.isEmpty(filed)) {
            String orderBy = "`" + filed + "`";
            if (!StringUtil.isEmpty(order)) {
                orderBy += order;
            }
            example.orderBy(orderBy);
        }

        if (categoryId != null && categoryId != 0) {
            criteria.andCategoryIdEqualTo(categoryId);
        }

        if (schoolId != null && schoolId != 0) {
            criteria.andSchoolIdEqualTo(schoolId);
        }

        if (!StringUtil.isEmpty(key)) {
            criteria.andNameLike("%" + key + "%");
        }

        criteria.andStatusEqualTo((byte) 1)
                .andIsOnSaleEqualTo((byte) 1)
                .andQuantityNotEqualTo(0);

        List<Goods> goods = goodsBaseService.queryByExampleAndPage(currentPageNum, pageSize, example);
        long total = PageInfo.of(goods).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("list", goods);

        return data;
    }

    public List<Goods> publishList(Integer uid) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        example.orderBy(Goods.Column.addTime.desc());
        criteria.andUidEqualTo(uid);
        return goodsBaseService.queryByExample(example);
    }


    public Goods detail(Integer id) {
        return goodsBaseService.findById(id);
    }

    public boolean add(Goods goods) {
        goods.setIsOnSale((byte) 0);
        goods.setType((byte) 0);
        goods.setStatus((byte) 1);
        BigDecimal normalPrice = goods.getNormalPrice();
        if (normalPrice != null) {
            BigDecimal price = goods.getPrice();
            byte discount = price
                    .divide(normalPrice, 2, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(100))
                    .byteValue();
            if (discount > 0 && discount < 99) {
                goods.setDiscount(discount);
            }
        }
        return goodsBaseService.add(goods);
    }

    public String isAvailable(Goods goods, Integer num) {
        if (null == goods) {
            return "商品不存在!";
        }

        if (0 == goods.getStatus()) {
            return "商品下架无法添加!";
        }

        if (1 != goods.getIsOnSale()) {
            return "商品审核未通过!";
        }

        Integer quantity = goods.getQuantity();

        if (quantity <= 0) {
            return "商品已售空!";
        }

        if (num != null && quantity < num) {
            return "商品数量只剩" + quantity + "个, 请修改数量";
        }
        return null;
    }

    public void view(Goods goods) {
        goods.setView(goods.getView() + 1);
        goodsBaseService.updateSelective(goods);
    }
}
