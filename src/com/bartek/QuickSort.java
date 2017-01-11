package com.bartek;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {1, 4, 3, 1, -9, 0, 8, 2, 3, 3, 6, 9, 2, 3};

        QuickSort.sort(array, 0, array.length -1 );
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array, int low, int high) {
        if (low < high) {
            int q = partition(array, low, high);
            sort(array, low, q - 1);
            sort(array, q + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int x = array[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (array[j] <= x) {
                i = i + 1;
                //exchange a[i] with a[j]
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }

        Collections.sort();

        //exchange a[i +1] with a[high]
        int temp = array[high];
        array[high] = array[i + 1];
        array[i + 1] = temp;
        return i + 1;
    }
}
