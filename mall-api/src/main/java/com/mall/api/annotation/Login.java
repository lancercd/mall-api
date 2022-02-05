package com.mall.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

/**
 * 验证token 和 手机号
 */
public @interface Login {
    /**
     * 验证登录
     */
    boolean requiredLogin() default true;
}
