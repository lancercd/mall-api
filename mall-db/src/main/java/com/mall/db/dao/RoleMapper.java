package com.mall.db.dao;

import com.mall.db.domain.Role;
import com.mall.db.domain.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectOneByExample(RoleExample example);

    Role selectOneByExampleSelective(@Param("example") RoleExample example, @Param("selective") Role.Column ... selective);

    List<Role> selectByExampleSelective(@Param("example") RoleExample example, @Param("selective") Role.Column ... selective);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Role.Column ... selective);

    Role selectByPrimaryKey(Integer id);

    Role selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    int logicalDeleteByExample(@Param("example") RoleExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}