package com.bartek.coursera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        int pivot;
        int pivotIndex;
        if (mode == MODE_FIRST) {
            pivotIndex = low;
        } else if (mode == MODE_LAST) {
            pivotIndex = high;
        } else {
            pivotIndex = (high + low) / 2;

        }

        pivot = array[pivotIndex];

        if (mode == MODE_LAST) {
            int temp = array[pivotIndex];
            array[pivotIndex] = array[low];
            array[low] = temp;
            pivotIndex = low;
        }

        if (mode == MODE_MEDIAN) {

            int pivotLow = array[low];
            int pivotHigh = array[high];
            int pivotMed = array[(low + high ) / 2];

            List<Integer> sublist = Arrays.asList(pivotLow, pivotMed, pivotHigh);
            Collections.sort(sublist);

            int medValue = sublist.get(1);

            for (int j = low; j <= high; j++) {
                if (array[j] == medValue) {
                    pivotIndex = j;
                    pivot = medValue;
                    break;
                }
            }

            int temp = array[pivotIndex];
            array[pivotIndex] = array[low];
            array[low] = temp;
            pivotIndex = low;
        }

        int i = low + 1;
        int current;

        numberOfComparisons += high - low;

        for (int j = low + 1; j <= high; j++) {
            current = array[j];
            if (array[j] <= pivot) {

                //exchange a[i] with a[j]
                array[j] = array[i];
                array[i] = current;
                i++;
            }
        }

        current = array[i - 1];
        array[i - 1] = pivot;
        array[pivotIndex] = current;
        return i - 1;
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
