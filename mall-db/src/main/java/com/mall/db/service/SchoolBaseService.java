package com.mall.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.mall.db.dao.SchoolMapper;
import com.mall.db.domain.School;
import com.mall.db.domain.SchoolExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SchoolBaseService extends BaseService {

    @Resource
    private SchoolMapper schoolMapper;

    public School findById(Integer id) {
        return schoolMapper.selectByPrimaryKey(id);
    }

    public boolean add(School school) {
        school.setAddTime(LocalDateTime.now());
        return schoolMapper.insert(school) != 0;
    }

    public School findByName(String name) {
        SchoolExample example = new SchoolExample();
        SchoolExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);

        return schoolMapper.selectOneByExampleSelective(example);
    }

    public boolean del(Integer id) {
        return schoolMapper.deleteByPrimaryKey(id) != 0;
    }

    public List<School> querySelective(String keywords, Integer page, Integer size, String order) {
        SchoolExample example = new SchoolExample();
        SchoolExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(keywords)) {
            criteria.andNameLike("%" + keywords + "%");
        }

        if (!StringUtils.isEmpty(order)) {
            example.setOrderByClause(" add_time " + order);
        }

        PageHelper.startPage(page, size);

        return schoolMapper.selectByExampleSelective(example);
    }
}
