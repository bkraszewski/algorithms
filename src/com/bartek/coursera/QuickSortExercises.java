package com.bartek.coursera;

import com.bartek.QuickSort;

import java.util.Arrays;

public class QuickSortExercises {
    private static final int MODE_FIRST = 1;
    private static final int MODE_LAST = 2;
    private static final int MODE_MEDIAN = 3;

    private static int numberOfComparisons = 0;


    public static int sort(int[] array, int mode) {
        numberOfComparisons = 0;
        sort(array, 0, array.length - 1, mode);
        System.out.println("Array: " + Arrays.toString(array));
        return numberOfComparisons;
    }

    private static int sort(int[] array, int low, int high, int mode) {
        if (low < high) {
            int q = partition(array, low, high, mode);
            sort(array, low, q - 1, mode);
            sort(array, q + 1, high, mode);
        }

        return numberOfComparisons;
    }

    private static int partition(int[] array, int low, int high, int mode) {
        int x;
        if (mode == MODE_FIRST) {
            x = array[low + 1];
        } else if (mode == MODE_LAST) {
            x = array[high];
        } else {
            x = array[(high + low)/2];
        }

        int i = low - 1;
        numberOfComparisons += high  - low;
        for (int j = low; j <= high - 1; j++) {
            if (array[j] <= x) {
                i = i + 1;
                //exchange a[i] with a[j]
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }


        //exchange a[i +1] with a[high]
        int temp = array[high];
        array[high] = array[i + 1];
        array[i + 1] = temp;
        return i + 1;
    }

    public static int quickSortSelectFirst(int[] array) {
        return sort(array, MODE_FIRST);
    }

    public static int quickSortSelectLast(int[] array) {
        return sort(array, MODE_LAST);
    }

    public static int quickSortSelectMedian(int[] array) {
        return sort(array, MODE_MEDIAN);
    }
}
