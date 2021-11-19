package com.mall.db.dao;

import com.mall.db.domain.MallAd;
import com.mall.db.domain.MallAdExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MallAdMapper {
    long countByExample(MallAdExample example);

    int deleteByExample(MallAdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallAd record);

    int insertSelective(MallAd record);

    MallAd selectOneByExample(MallAdExample example);

    MallAd selectOneByExampleSelective(@Param("example") MallAdExample example, @Param("selective") MallAd.Column ... selective);

    List<MallAd> selectByExampleSelective(@Param("example") MallAdExample example, @Param("selective") MallAd.Column ... selective);

    List<MallAd> selectByExample(MallAdExample example);

    MallAd selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MallAd.Column ... selective);

    MallAd selectByPrimaryKey(Integer id);

    MallAd selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MallAd record, @Param("example") MallAdExample example);

    int updateByExample(@Param("record") MallAd record, @Param("example") MallAdExample example);

    int updateByPrimaryKeySelective(MallAd record);

    int updateByPrimaryKey(MallAd record);

    int logicalDeleteByExample(@Param("example") MallAdExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}