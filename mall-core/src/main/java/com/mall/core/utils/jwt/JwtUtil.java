package com.mall.core.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mall.core.exception.TokenException;

import java.util.Date;

public class JwtUtil {

    private static final String SIGNATURE = "lancer-mall-proj";

    private static final long EXP = 1000 * 60 * 60 * 3;

    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SIGNATURE);


    public static JWTCreator.Builder getJwtBuilder() {
        long currentTime = System.currentTimeMillis();

        return JWT.create()
                .withIssuer("lancer")
                .withIssuedAt(new Date(currentTime))
                .withSubject("lancer-mall")
                .withExpiresAt(new Date(currentTime + EXP))
                .withClaim("author", "lancer");
    }

    public static String sign(JWTCreator.Builder builder) {
        return builder.sign(ALGORITHM);
    }

    public static DecodedJWT verifyAndDecodeToken(String token) {
        if (null == token || token.isEmpty()) {
            throw new TokenException("未登录!");
        }

        DecodedJWT decodedJWT = null;
        try {
            decodedJWT = JWT.require(ALGORITHM).build().verify(token);
        } catch (Exception e) {
            throw new TokenException("未登录!");
        }

        return decodedJWT;

        /*
        try {
            JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
            map.put("status", true);
            return map;
        }catch (TokenExpiredException e){
            e.printStackTrace();
            map.put("msg","token过期");
        }catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", "无效签名");
        }catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg","算法不一致");
        }catch (Exception e) {
            e.printStackTrace();
            map.put("msg","token无效");
        }
         */
    }
}
