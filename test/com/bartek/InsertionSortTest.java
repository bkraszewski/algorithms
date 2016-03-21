package com.bartek;

import org.junit.Test;

import java.util.Arrays;

public class InsertionSortTest {
    @Test
    public void shouldSort(){
        int arr[] = {64,25,12,22,11};
        arr = InsertionSort.sort(arr);
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));
    }
}
