package com.mall.db.service;

import com.mall.db.dao.CategoryMapper;
import com.mall.db.domain.Category;
import com.mall.db.domain.CategoryExample;
import com.mall.db.exception.ServiceBadArgumentException;
import com.mall.db.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    public Category findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public boolean add (Category category) {

        if (null == category || StringUtil.isEmpty(category.getName())) {
            throw new ServiceBadArgumentException("分类名不能为空!");
        }

        category.setId(null);
        int i = categoryMapper.insertSelective(category);
        System.out.println(i);
        return true;
    }

    public List<Category> getList() {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        // criteria.andIdEqualTo(1);
        return categoryMapper.selectByExample(example);
    }
}
