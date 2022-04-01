package com.mall.db.dao;

import com.mall.db.domain.Banner;
import com.mall.db.domain.BannerExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BannerMapper {
    long countByExample(BannerExample example);

    int deleteByExample(BannerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectOneByExample(BannerExample example);

    Banner selectOneByExampleSelective(@Param("example") BannerExample example, @Param("selective") Banner.Column ... selective);

    List<Banner> selectByExampleSelective(@Param("example") BannerExample example, @Param("selective") Banner.Column ... selective);

    List<Banner> selectByExample(BannerExample example);

    Banner selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Banner.Column ... selective);

    Banner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}