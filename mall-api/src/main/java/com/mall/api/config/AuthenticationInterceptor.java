package com.mall.api.config;

import com.mall.api.annotation.support.UserTokenManager;
import com.mall.db.service.UserBaseService;
import com.mall.api.annotation.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

import static com.mall.api.annotation.support.LoginUserHandlerMethodArgumentResolver.LOGIN_TOKEN_KEY;


@Configuration
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserBaseService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("api preHandle");
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method=handlerMethod.getMethod();

        if (method.isAnnotationPresent(Login.class)) {
            String token = request.getHeader(LOGIN_TOKEN_KEY);
            Login jwtToken = method.getAnnotation(Login.class);
            if (jwtToken.requiredLogin()) {
                UserTokenManager.verify(token);
                // if(jwtToken.requiredPhone()){
                //     User user = userService.findById(uid);
                //
                //     //是否被拉黑  被拉黑则显示拉黑原因
                //     Byte status = user.getStatus();
                //     Integer reasonId = user.getReasonId();
                //     if(status != 0){
                //         throw new BlacklistException(description);
                //     }
                // }
            }

        }

        return true;
    }
}
