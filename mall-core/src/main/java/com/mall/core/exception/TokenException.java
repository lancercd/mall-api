package com.mall.core.exception;


/**
 * header中token为空  抛出此异常
 * token过期          抛出此异常
 */
public class TokenException extends RuntimeException {
    public TokenException() {
    }

    public TokenException(String message) {
        super(message);
    }
}
