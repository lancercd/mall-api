package com.mall.db.service;

import com.mall.db.dao.UserMapper;
import com.mall.db.domain.User;
import com.mall.db.domain.User.Column;
import com.mall.db.domain.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class UserBaseService extends BaseService {
    @Resource
    private UserMapper userMapper;

    Column[] list = new Column[]{
            Column.id,
            Column.username,
    };

    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User findByUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameLike('%' + username + '%');
        return userMapper.selectOneByExampleSelective(example);
    }

    public boolean add(User user) {
        user.setAddTime(LocalDateTime.now());
        user.setStatus((byte)0);
        return userMapper.insert(user) == 1;
    }
}
