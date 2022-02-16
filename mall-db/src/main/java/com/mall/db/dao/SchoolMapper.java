package com.mall.db.dao;

import com.mall.db.domain.School;
import com.mall.db.domain.SchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SchoolMapper {
    long countByExample(SchoolExample example);

    int deleteByExample(SchoolExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(School record);

    int insertSelective(School record);

    School selectOneByExample(SchoolExample example);

    School selectOneByExampleSelective(@Param("example") SchoolExample example, @Param("selective") School.Column ... selective);

    List<School> selectByExampleSelective(@Param("example") SchoolExample example, @Param("selective") School.Column ... selective);

    List<School> selectByExample(SchoolExample example);

    School selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") School.Column ... selective);

    School selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByExample(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);
}