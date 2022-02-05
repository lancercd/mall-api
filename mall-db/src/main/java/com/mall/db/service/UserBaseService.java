package com.mall.db.service;

import com.mall.db.dao.UserMapper;
import com.mall.db.domain.Goods;
import com.mall.db.domain.User;
import com.mall.db.domain.User.Column;
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

    public boolean add(User user) {
        // user.setAddTime(LocalDateTime.now());
        return userMapper.insert(user) == 1;
    }
}
