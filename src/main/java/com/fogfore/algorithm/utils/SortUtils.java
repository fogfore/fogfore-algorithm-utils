package com.fogfore.algorithm.utils;


import java.util.concurrent.ThreadLocalRandom;

public class SortUtils {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    /**
     * 两路归并排序
     *
     * @param array
     */
    public static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    /**
     * 快速排序
     *
     * @param array
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * 随机快速排序
     *
     * @param array
     */
    public static void randomQuickSort(int[] array) {
        randomQuickSort(array, 0, array.length - 1);
    }

    /**
     * 堆排序
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        buildMaxHeap(array, array.length);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustMaxHeap(array, 0, i);
        }
    }

    private static void buildMaxHeap(int[] array, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(array, i, len);
        }
    }

    private static void buildMinHeap(int[] array, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustMinHeap(array, i, len);
        }
    }

    private static void adjustMaxHeap(int[] array, int i, int len) {
        int t = array[i];
        for (int j = 2 * i + 1; j < len; j = 2 * i + 1) {
            if (j < len - 1 && array[j] < array[j + 1]) j++;
            if (t >= array[j]) break;
            array[i] = array[j];
            i = j;
        }
        array[i] = t;
    }

    private static void adjustMinHeap(int[] array, int i, int len) {
        int t = array[i];
        for (int j = 2 * i + 1; j < len; j = 2 * i + 1) {
            if (j < len - 1 && array[j] > array[j + 1]) j++;
            if (t <= array[j]) break;
            array[i] = array[j];
            i = j;
        }
        array[i] = t;
    }

    private static int insertMaxHeap(int[] array, int len, int value) {
        if (len >= array.length) {
            return -1;
        }
        int cur = len;
        for (int i = (cur - 1) / 2; i >= 0; i = (i - 1) / 2) {
            if (array[i] < value) {
                array[cur] = array[i];
                cur = i;
            }
        }
        array[cur] = value;
        return cur;
    }

    private static int insertMinHeap(int[] array, int len, int value) {
        if (len >= array.length) {
            return -1;
        }
        int cur = len;
        for (int i = (cur - 1) / 2; i >= 0; i = (i - 1) / 2) {
            if (array[i] > value) {
                array[cur] = array[i];
                cur = i;
            }
        }
        array[cur] = value;
        return cur;
    }

    private static void mergeSort(int[] source, int[] temp, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(source, temp, low, mid);
        mergeSort(source, temp, mid + 1, high);

        int i1 = low;
        int i2 = mid + 1;
        int i3 = low;
        while (i1 <= mid && i2 <= high) {
            if (source[i1] < source[i2]) {
                temp[i3] = source[i1];
                i1++;
            } else {
                temp[i3] = source[i2];
                i2++;
            }
            i3++;
        }
        if (i1 <= mid) {
            System.arraycopy(source, i1, temp, i3, mid - i1 + 1);
        }
        if (i2 <= high) {
            System.arraycopy(source, i2, temp, i3, high - i2 + 1);
        }
        System.arraycopy(temp, low, source, low, high - low + 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = partition(array, low, high, false);
            quickSort(array, low, mid - 1);
            quickSort(array, mid + 1, high);
        }
    }

    private static void randomQuickSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = partition(array, low, high, true);
            randomQuickSort(array, low, mid - 1);
            randomQuickSort(array, mid + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high, boolean isRandom) {
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

    private static void swap(int[] array, int src, int dest) {
        if (src == dest) {
            return;
        }
        array[src] = array[src] ^ array[dest];
        array[dest] = array[src] ^ array[dest];
        array[src] = array[src] ^ array[dest];
    }
}
