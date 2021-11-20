package com.mall.db.dao;

import com.mall.db.domain.Category;
import com.mall.db.domain.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectOneByExample(CategoryExample example);

    Category selectOneByExampleSelective(@Param("example") CategoryExample example, @Param("selective") Category.Column ... selective);

    List<Category> selectByExampleSelective(@Param("example") CategoryExample example, @Param("selective") Category.Column ... selective);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Category.Column ... selective);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}