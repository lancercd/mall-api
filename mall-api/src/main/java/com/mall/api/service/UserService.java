package com.mall.api.service;

import com.mall.api.annotation.support.UserTokenManager;
import com.mall.api.dao.UserToken;
import com.mall.api.dto.request.UserLoginAndRegister;
import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.User;
import com.mall.db.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserBaseService userBaseService;

    public Object login(UserLoginAndRegister loginUser) {
        String username = loginUser.getUsername();
        User user = userBaseService.findByUsername(username);

        if (null == user) {
            return ResponseUtil.fail("用户名或密码错误!");
        }

        if (user.getStatus() != 0) {
            return ResponseUtil.fail("用户名已被封禁,请联系管理员!");
        }

        if (!user.getPwd().equals(loginUser.getPwd())) {
            return ResponseUtil.fail("密码错误!");
        }

        return loginSuccess(user);
    }

    public Object register(UserLoginAndRegister registerUser) {
        User hasUser = userBaseService.findByUsername(registerUser.getUsername());
        if (null != hasUser) {
            return ResponseUtil.fail("该用户名已被占用!");
        }

        User user = userBaseService.map(registerUser, User.class);
        if (!userBaseService.add(user)) {
            return ResponseUtil.fail("注册失败!");
        }

        return loginSuccess(user);
    }

    private Object loginSuccess(User user) {
        user.setPwd(null);
        user.setStatus(null);

        UserToken userToken = UserTokenManager.generateToken(user.getId());

        Map<String, Object> res = new HashMap<>();
        res.put("token", userToken.getToken());
        res.put("user", user);
        return ResponseUtil.ok(res);
    }
}
