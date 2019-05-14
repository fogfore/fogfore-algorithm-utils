package com.fogfore.algorithm.utils;

import java.util.concurrent.ThreadLocalRandom;

public class ArrayFactory {
    public static final int MAX_ARRAY_LEN = 50;
    public static final int MAX_VALUE = 100;
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static int[] getOneDimensionalArray() {
        return getOneDimensionalArray(MAX_ARRAY_LEN, MAX_VALUE);
    }

    public static int[] getOneDimensionalArray(int len) {
        return getOneDimensionalArray(len, MAX_VALUE);
    }

    public static int[] getOneDimensionalArray(int len, int maxValue) {
        if (len < 1 || maxValue < 1 || maxValue >= Integer.MAX_VALUE) {
            return null;
        }
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = RANDOM.nextInt(maxValue + 1);
        }
        return array;
    }

    public static int[][] getTwoDimensionalArray(int rowNum, int colNum) {
        return getTwoDimensionalArray(rowNum, colNum, MAX_VALUE);
    }

    public static int[][] getTwoDimensionalArray(int rowNum, int colNum, int maxValue) {
        if (rowNum < 1 || colNum < 1 || maxValue < 1) {
            return null;
        }
        int[][] array = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            array[i] = getOneDimensionalArray(colNum, maxValue);
        }
        return array;
    }
}
