package com.bartek;

public class CountCommonNumbers {
    public static int countCommonNumbers(int[] sorted, int[] distinct) {
        int total = 0;
        for (int i : distinct) {
            total += hasNumberInSortedRange(sorted, 0, sorted.length - 1, i) ? 1 : 0;
        }

        return total;
    }

    private static boolean hasNumberInSortedRange(int[] sorted, int startIndex, int endIndex, int number) {
        if (sorted.length == 0) {
            return false;
        }

        System.out.println(String.format("Testing for start: %d, end: %d, looking for: %d", startIndex, endIndex, number));

        if (startIndex > endIndex) {
            return false;
        }

        if (endIndex == startIndex) {
            return sorted[startIndex] == number;
        }

        int midIndex = endIndex - (endIndex - startIndex) / 2;

        if (sorted[midIndex] == number) {
            return true;
        } else if (sorted[midIndex] > number) {

            int newStart = startIndex;
            int newEnd = midIndex - 1;

            return hasNumberInSortedRange(sorted, newStart, newEnd, number);
        } else {
            int newStart = midIndex + 1;
            int newEnd = endIndex;

            return hasNumberInSortedRange(sorted, newStart, newEnd, number);
        }
    }

    private static boolean testBruteForce(int[] sorted, int number) {
        for (int a = 0; a < sorted.length; a++) {
            if (sorted[a] == number) {
                return true;
            }
        }

        return false;
    }
}
