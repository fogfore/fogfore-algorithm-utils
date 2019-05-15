package com.fogfore.algorithm.utils;

import java.util.concurrent.ThreadLocalRandom;

public class ArrayFactory {
    public static final int MAX_LEN = 50;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 100;

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static int[] getOneArray() {
        return getOneArray(MAX_LEN, MIN_VALUE, MAX_VALUE);
    }

    public static int[] getOneArray(int len) {
        return getOneArray(len, MIN_VALUE, MAX_VALUE);
    }

    public static int[] getOneArray(int len, int minValue, int maxValue) {
        if (len < 1 || !(0 <= minValue && minValue < maxValue && maxValue < Integer.MAX_VALUE)) {
            return null;
        }
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = RANDOM.nextInt(minValue, maxValue + 1);
        }
        return array;
    }

    public static int[] getOrderUnrepeatedArray(int len, int minValue, int maxValue) {
        int delta = maxValue - (minValue + len - 1);
        if (delta < 0) {
            return null;
        }
        int[] array = new int[len];
        int origin = minValue;
        for (int i = 0; i < len; i++) {
            if (delta > 0 && RANDOM.nextBoolean()) {
                array[i] = RANDOM.nextInt(origin, origin + delta + 1);
                delta = origin + delta - array[i];
                origin = array[i] + 1;
                continue;
            }
            array[i] = origin;
            origin++;
        }
        return array;
    }

    public static int[] getOrderArray(int len, int minValue, int maxValue) {
        if (minValue >= maxValue) {
            return null;
        }
        int[] array = getOneArray(len, minValue, maxValue);
        SortUtils.quickSort(array);
        return array;
    }

    public static int[][] getTwoArray(int rowNum, int colNum) {
        return getTwoArray(rowNum, colNum, MIN_VALUE, MAX_VALUE);
    }

    public static int[][] getTwoArray(int rowNum, int colNum, int minValue, int maxValue) {
        if (rowNum < 1 || colNum < 1 || !(0 <= minValue && minValue < maxValue && maxValue < Integer.MAX_VALUE)) {
            return null;
        }
        int[][] array = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            array[i] = getOneArray(colNum, minValue, maxValue);
        }
        return array;
    }
}
