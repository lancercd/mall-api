package com.mall.core.utils.jwt;

import com.auth0.jwt.JWTCreator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class JwtUtilTest {

    @Test
    public void token() {
        JWTCreator.Builder builder = JwtUtil.getJwtBuilder().withClaim("id", 1);
        String token = JwtUtil.sign(builder);
        System.out.println(token);

        JwtUtil.verifyAndDecodeToken(token);
    }

}