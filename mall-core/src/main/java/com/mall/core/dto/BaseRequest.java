package com.mall.core.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 请求基类
 *
 */
@Setter
@Getter
public abstract class BaseRequest implements Serializable {

    private static final long serialVersionUID = -9031286963149268101L;

    private int page = 1;

    private int pageSize = 10;
}
