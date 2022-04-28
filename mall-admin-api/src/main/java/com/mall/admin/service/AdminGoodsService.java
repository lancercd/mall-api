package com.mall.admin.service;


import com.github.pagehelper.PageInfo;
import com.mall.core.dto.GoodsDTO;
import com.mall.core.utils.RegexUtil;
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


    public Goods detail(Integer id) {
        return goodsBaseService.findById(id);
    }


    /**
     * 添加或更新
     *      通过id区分
     * @param goodsDTO validated商品
     * @return boolean
     */
    public boolean addOrUpdate(GoodsDTO goodsDTO) {

        Goods goods = goodsBaseService.map(goodsDTO, Goods.class);

        if (!this.imageUrlsValidate(goods)) {
            throw new ServiceBadArgumentException("图片url不符合要求!");
        }

        if (null != goods.getId()) {
            return goodsBaseService.updateSelective(goods);
        }
        return goodsBaseService.addSelective(goods);
    }

    /**
     * 商品列表
     * @param currentPageNum 当前页码
     * @param pageSize  每页大小
     * @param type  通过什么搜索
     * @param key   搜索的keywords
     * @return list and total
     */
    public Map<String, Object> list(Integer currentPageNum, Integer pageSize, String type, String key) {
        List<Goods> goods = goodsBaseService.querySelective(currentPageNum, pageSize, type, key);
        long total = PageInfo.of(goods).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("list", goods);

        return data;
    }

    /**
     * 修改商品状态
     * @param id    商品id
     * @param status    状态
     * @return boolean
     */
    public boolean changeState(Integer id, Byte status) {
        if (null == id || null == status || null == goodsBaseService.findById(id)) {
            throw new ServiceBadArgumentException("参数错误!");
        }

        Goods goods = new Goods();
        goods.setId(id);
        goods.setStatus(status);

        return goodsBaseService.updateSelective(goods);
    }

    /**
     * 对图片url进行校验
     * @param goods 商品
     * @return boolean
     */
    private boolean imageUrlsValidate(Goods goods) {

        // String[] images = goods.getImages();
        // if(null == images) return false;
        //
        // for (String image : images) {
        //     if (!RegexUtil.isImageUrl(image)) return false;
        // }

        return true;
    }

    public Map<String, Long> countInfo() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("all", goodsBaseService.count());
        map.put("active", goodsBaseService.countActive());

        return map;
    }

    public boolean pass(Integer id) {
        Goods goods = goodsBaseService.findById(id);
        goods.setIsOnSale((byte) 1);
        return goodsBaseService.updateSelective(goods);
    }

    public boolean del(Integer id) {
        return goodsBaseService.delById(id);
    }
}
