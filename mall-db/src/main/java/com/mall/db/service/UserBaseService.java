package com.mall.db.service;

import com.github.pagehelper.PageHelper;
import com.mall.db.dao.UserMapper;
import com.mall.db.domain.User;
import com.mall.db.domain.User.Column;
import com.mall.db.domain.UserExample;
import com.mall.db.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

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

    public List<User> querySelective(Integer currentPageNum, Integer pageSize, Integer status, String type, String key) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        if (!StringUtil.isEmpty(type) && !StringUtil.isEmpty(key)) {
            if (User.Column.username.value().equals(type)) {
                criteria.andUsernameLike('%' + key + '%');
            }
        }

        if (status != null) {
            criteria.andStatusEqualTo(status.byteValue());
        }

        example.orderBy(User.Column.addTime.desc());

        PageHelper.startPage(currentPageNum, pageSize);

        return userMapper.selectByExampleSelective(example);
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

    public boolean updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user) != 0;
    }

    public long count() {
        UserExample example = new UserExample();
        return userMapper.countByExample(example);
    }

    public long countActive() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        criteria.andAddTimeGreaterThan(LocalDateTime.now().minusDays(1));

        return userMapper.countByExample(example);
    }
}
