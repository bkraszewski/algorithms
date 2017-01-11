package com.bartek.coursera;

import java.util.Arrays;

public class InversionsDetector {

    public static long countInversions(int[] input) {

        if (input.length < 2) {
            return 0;
        }

        int midIndex = (input.length + 1) / 2;

        int[] first = Arrays.copyOfRange(input, 0, midIndex);
        int[] second = Arrays.copyOfRange(input, midIndex, input.length);

        long x = countInversions(first);
        long y = countInversions(second);
        long z = countSplitInversions(input, first, second);

        return x + y + z;

    }

    private static long countSplitInversions(int[] input, int[] first, int[] second) {
        int i = 0, j = 0, count = 0;
        while (i < first.length || j < second.length) {
            if (i == first.length) {
                input[i + j] = second[j];
                j++;
            } else if (j == second.length) {
                input[i + j] = first[i];
                i++;
            } else if (first[i] <= second[j]) {
                input[i + j] = first[i];
                i++;
            } else {
                input[i + j] = second[j];
                count += first.length - i;
                j++;
            }
        }
        return count;
    }
}
