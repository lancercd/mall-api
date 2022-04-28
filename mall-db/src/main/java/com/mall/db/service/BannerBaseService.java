package com.mall.db.service;

import com.github.pagehelper.PageHelper;
import com.mall.db.dao.BannerMapper;
import com.mall.db.domain.Banner;
import com.mall.db.domain.BannerExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerBaseService extends BaseService {
    @Resource
    private BannerMapper bannerMapper;

    public Banner findById(Integer id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    public List<Banner> querySelective() {
        BannerExample example = new BannerExample();
        BannerExample.Criteria criteria = example.createCriteria();

        return bannerMapper.selectByExample(example);
    }


}
