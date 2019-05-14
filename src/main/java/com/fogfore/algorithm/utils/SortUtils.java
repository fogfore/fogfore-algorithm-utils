package com.fogfore.algorithm.utils;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

import java.util.concurrent.ThreadLocalRandom;

public class SortUtils {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = partition(array, low, high, false);
            quickSort(array, low, mid - 1);
            quickSort(array, mid + 1, high);
        }
    }


    public static void randomQuickSort(int[] array) {
        randomQuickSort(array, 0, array.length - 1);
    }

    public static void randomQuickSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = partition(array, low, high, true);
            randomQuickSort(array, low, mid - 1);
            randomQuickSort(array, mid + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high, boolean isRandom) {
        if (low > high) {
            return -1;
        }
        if (isRandom) {
            int index = RANDOM.nextInt(low, high + 1);
            swap(array, index, high);
        }
        int small = low - 1;
        int temp = array[high];
        for (int i = low; i < high; i++) {
            if (array[i] < temp) {
                small++;
                if (small != i) {
                    swap(array, small, i);
                }
            }
        }
        small++;
        swap(array, small, high);
        return small;
    }

    public static void swap(int[] array, int origin, int dest) {
        int temp = array[origin];
        array[origin] = array[dest];
        array[dest] = temp;
    }
}
