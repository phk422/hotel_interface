package com.school.hotel.util;

import java.util.Base64;

/**
 * 基于原生Java的Base64的加密解密工具包
 */
public class Base64Utils {
    private static final String SALT = "p_hotel"; //公共盐值，不对外公布
    private static final int REPEAT = 6; // 加密次数，不对外公布

    /**
     * 加密方法
     * @param str 需要加密字符串
     * @return 加密后的字符串
     */
    public static String encode(String str) {
        String temp = str + "{" + SALT + "}";  // 加密处理
        byte[] bytes = temp.getBytes();  // 把字符串变为字节数组
        for (int i = 0; i < REPEAT; i++) {
            bytes = Base64.getEncoder().encode(bytes);  // 重复加密
        }
        return new String(bytes);
    }

    /**
     * 解密方法
     * @param str 密文
     * @return 原始数据
     */
    public static String decode(String str) {
        byte[] bytes = str.getBytes(); // 获取加密内容
        for (int i = 0; i < REPEAT; i++) {
            bytes = Base64.getDecoder().decode(bytes);  // 多次解密
        }
        return new String(bytes).replaceAll("\\{\\w+\\}",""); // 将盐值的格式去
    }

}
