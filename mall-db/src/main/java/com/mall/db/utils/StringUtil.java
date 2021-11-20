package com.mall.db.utils;

public final class StringUtil {
    public static final String EMPTY_STRING = "";

    /**
     * 判断字符串是否为空
     * @param str 目标字符串
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        return (str == null || EMPTY_STRING.equals(str));
    }
}
