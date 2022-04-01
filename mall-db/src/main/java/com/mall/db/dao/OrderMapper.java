package com.mall.db.dao;

import com.mall.db.domain.Order;
import com.mall.db.domain.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectOneByExample(OrderExample example);

    Order selectOneByExampleSelective(@Param("example") OrderExample example, @Param("selective") Order.Column ... selective);

    List<Order> selectByExampleSelective(@Param("example") OrderExample example, @Param("selective") Order.Column ... selective);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Order.Column ... selective);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}