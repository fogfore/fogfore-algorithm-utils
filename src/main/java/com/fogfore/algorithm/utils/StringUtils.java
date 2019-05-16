package com.fogfore.algorithm.utils;

public class StringUtils {
    public static String reverse(String str) {
        return reverse(str, 0, str.length() - 1);
    }


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
