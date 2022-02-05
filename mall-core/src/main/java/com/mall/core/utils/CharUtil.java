package com.mall.core.utils;

import java.util.Random;

public class CharUtil {
    private static Random random = new Random();

    private static String stringBaseChar = "abcdefghijklmnopqrstuvwxyz0123456789";

    private static String numBaseChar = "0123456789";

    public static String getRandomString(Integer num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(stringBaseChar.length());
            sb.append(stringBaseChar.charAt(number));
        }
        return sb.toString();
    }

    public static String getRandomNum(Integer num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(numBaseChar.length());
            sb.append(numBaseChar.charAt(number));
        }
        return sb.toString();
    }

}
