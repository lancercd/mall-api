package com.mall.db.dao;

import com.mall.db.domain.OrderDetail;
import com.mall.db.domain.OrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDetailMapper {
    long countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectOneByExample(OrderDetailExample example);

    OrderDetail selectOneByExampleSelective(@Param("example") OrderDetailExample example, @Param("selective") OrderDetail.Column ... selective);

    List<OrderDetail> selectByExampleSelective(@Param("example") OrderDetailExample example, @Param("selective") OrderDetail.Column ... selective);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") OrderDetail.Column ... selective);

    OrderDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}