package com.fogfore.algorithm.utils;

public class MathUtils {
    public static int min(int v1, int v2, int v3) {
        if (v1 < v2) {
            return v1 < v3 ? v1 : v3;
        } else {
            return v2 < v3 ? v2 : v3;
        }
    }
}
