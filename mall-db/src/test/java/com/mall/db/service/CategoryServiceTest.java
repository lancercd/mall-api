package com.mall.db.service;

import com.mall.db.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryBaseService categoryService;

    @Test
    public void findById() {
        Category byId = categoryService.findById(1);
        System.out.println(byId);

    }
}