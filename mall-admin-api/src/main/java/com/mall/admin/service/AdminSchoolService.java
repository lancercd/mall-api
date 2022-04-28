package com.mall.admin.service;

import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.School;
import com.mall.db.service.SchoolBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSchoolService {

    @Autowired
    private SchoolBaseService schoolBaseService;

    public Object add(String name) {
        School sch = schoolBaseService.findByName(name);
        if (null != sch) {
            return ResponseUtil.fail("该学校已存在!");
        }
        School school = new School();
        school.setName(name);
        schoolBaseService.add(school);
        return ResponseUtil.ok();
    }

    public Object del(Integer id) {
        School sch = schoolBaseService.findById(id);
        if (null == sch) {
            return ResponseUtil.fail("学校不存在!");
        }
        schoolBaseService.del(id);
        return ResponseUtil.ok();
    }

    public List<School> queryList(String keywords, Integer page, Integer size, String order) {

        return schoolBaseService.querySelective(keywords, page, size, order);
    }

}
