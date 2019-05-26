package com.fogfore.algorithm.utils;

public class MathUtils {
    /**
     * 求最小值
     *
     * @param values 集合
     * @return 最小值
     */
    public static int min(int... values) {
        int min = Integer.MAX_VALUE;
        for (int v : values) {
            min = v < min ? v : min;
        }
        return min;
    }
}
