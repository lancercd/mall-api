package com.mall.api.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserToken {
    private Integer userId;
    private String token;
    private String sessionKey;
}
