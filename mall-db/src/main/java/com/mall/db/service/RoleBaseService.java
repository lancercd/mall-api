package com.mall.db.service;

import com.mall.db.dao.RoleMapper;
import com.mall.db.domain.Role;
import com.mall.db.domain.RoleExample;
import com.mall.db.exception.ServiceBadArgumentException;
import com.mall.db.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleBaseService extends BaseService {

    @Resource
    private RoleMapper roleMapper;

    public Role findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public boolean add(Role role) {
        if (null == role || StringUtil.isEmpty(role.getName())) {
            throw new ServiceBadArgumentException("角色名不能为空!");
        }

        role.setId(null);
        return roleMapper.insertSelective(role) == 1;
    }

    public boolean modify(Role category) {
        if (null == category || StringUtil.isEmpty(category.getName())) {
            throw new ServiceBadArgumentException("角色名不能为空!");
        }

        Integer id = category.getId();
        if (null == id || id.compareTo(0) < 1) {
            throw new ServiceBadArgumentException("id错误!");
        }

        if (null == findById(id)) {
            throw new ServiceBadArgumentException("该id不存在!");
        }

        return roleMapper.updateByPrimaryKey(category) == 1;
    }

    public List<Role> getList() {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        // criteria.andIdEqualTo(1);
        return roleMapper.selectByExample(example);
    }
}
