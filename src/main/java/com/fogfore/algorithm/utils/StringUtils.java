package com.fogfore.algorithm.utils;

public class StringUtils {
    /**
     * 字符串反转
     *
     * @param str
     * @return 反转后的字符串
     */
    public static String reverse(String str) {
        return reverse(str, 0, str.length() - 1);
    }

    /**
     * 字符串反转
     *
     * @param str
     * @param start 开始（包含当前位置）
     * @param end   结束（包含当前位置）
     * @return
     */
    public static String reverse(String str, int start, int end) {
        char[] chars = str.toCharArray();
        char temp;
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }
}
