package com.bartek;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommonNumbersTest {


    @Test
    public void shouldCountCommonNumberForTwoArrays() {
        int[] sorted = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] distinct = {3, 8};

        assertEquals(2, CountCommonNumbers.countCommonNumbers(sorted, distinct));
    }

    @Test
    public void shouldCountCommonNumberForTwoArrays2() {
        int[] sorted = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] distinct = {12, -1};

        assertEquals(0, CountCommonNumbers.countCommonNumbers(sorted, distinct));
    }
}
