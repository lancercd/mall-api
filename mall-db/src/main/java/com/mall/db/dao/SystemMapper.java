package com.mall.db.dao;

import com.mall.db.domain.System;
import com.mall.db.domain.SystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SystemMapper {
    long countByExample(SystemExample example);

    int deleteByExample(SystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(System record);

    int insertSelective(System record);

    System selectOneByExample(SystemExample example);

    System selectOneByExampleSelective(@Param("example") SystemExample example, @Param("selective") System.Column ... selective);

    List<System> selectByExampleSelective(@Param("example") SystemExample example, @Param("selective") System.Column ... selective);

    List<System> selectByExample(SystemExample example);

    System selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") System.Column ... selective);

    System selectByPrimaryKey(Integer id);

    System selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") System record, @Param("example") SystemExample example);

    int updateByExample(@Param("record") System record, @Param("example") SystemExample example);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);

    int logicalDeleteByExample(@Param("example") SystemExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}