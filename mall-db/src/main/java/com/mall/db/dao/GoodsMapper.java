package com.mall.db.dao;

import com.mall.db.domain.Goods;
import com.mall.db.domain.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectOneByExample(GoodsExample example);

    Goods selectOneByExampleSelective(@Param("example") GoodsExample example, @Param("selective") Goods.Column ... selective);

    Goods selectOneByExampleWithBLOBs(GoodsExample example);

    List<Goods> selectByExampleSelective(@Param("example") GoodsExample example, @Param("selective") Goods.Column ... selective);

    List<Goods> selectByExampleWithBLOBs(GoodsExample example);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Goods.Column ... selective);

    Goods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);
}