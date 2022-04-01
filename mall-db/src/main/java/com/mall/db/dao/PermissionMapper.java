package com.mall.db.dao;

import com.mall.db.domain.Permission;
import com.mall.db.domain.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectOneByExample(PermissionExample example);

    Permission selectOneByExampleSelective(@Param("example") PermissionExample example, @Param("selective") Permission.Column ... selective);

    List<Permission> selectByExampleSelective(@Param("example") PermissionExample example, @Param("selective") Permission.Column ... selective);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Permission.Column ... selective);

    Permission selectByPrimaryKey(Integer id);

    Permission selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    int logicalDeleteByExample(@Param("example") PermissionExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}