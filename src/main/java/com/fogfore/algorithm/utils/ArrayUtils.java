package com.fogfore.algorithm.utils;

import java.util.Arrays;
import java.util.StringJoiner;

public class ArrayUtils {
    public static String toString(int[][] matrix) {
        StringJoiner joiner = new StringJoiner(",\n ", "{", "}");
        for (int i = 0; i < matrix.length; i++) {
            joiner.add(Arrays.toString(matrix[i]));
        }
        return joiner.toString();
    }
}
