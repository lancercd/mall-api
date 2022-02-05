package com.mall.api.annotation.support;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.mall.api.dao.UserToken;
import com.mall.core.utils.jwt.JwtUtil;

/**
 * 维护用户token
 */
public class UserTokenManager {
    private static final String CLAIM_KEY ="uid";

    public static Integer getUserId(String token) {
        DecodedJWT decodedJWT = JwtUtil.verifyAndDecodeToken(token);
        // if (userToken.getExpireTime().isBefore(LocalDateTime.now())) {}

        return decodedJWT.getClaim(CLAIM_KEY).asInt();
    }

    public static void verify(String token) {
        JwtUtil.verifyAndDecodeToken(token);
    }


    public static UserToken generateToken(Integer id) {
        String token = JwtUtil.sign(JwtUtil.getJwtBuilder().withClaim(CLAIM_KEY, id));

        UserToken userToken = new UserToken();
        userToken.setToken(token);
        userToken.setUserId(id);

        return userToken;
    }
}
