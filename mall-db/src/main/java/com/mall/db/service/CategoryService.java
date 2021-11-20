package com.mall.db.service;

import com.mall.db.dao.CategoryMapper;
import com.mall.db.domain.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    public Category findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
}
