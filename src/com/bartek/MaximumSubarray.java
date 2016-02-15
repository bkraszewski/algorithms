package com.bartek;


import org.junit.rules.Stopwatch;

public class MaximumSubarray {

    static class SubarrayData {
        int low;
        int high;
        int sum;

        public SubarrayData(int low, int high, int sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, -1, 7, -9, 3, 0, 4, -2};

        //SubarrayData data = findMaximumSubarray(array, 0, array.length - 1);
        //SubarrayData data = findMaximumSubarrayBruteforce(array);
        //System.out.println(String.format("Max sum: %d From %d To %d", data.sum, data.low, data.high));

        findMaximumSubarrayLinear(array);
    }

    public static SubarrayData findMaximumSubarray(int[] array, int low, int high) {
        if (low == high) {
            return new SubarrayData(low, high, array[low]);
        }

        System.out.println(String.format("Testing low: %d high: %d", low, high));

        int mid = (low + high) / 2;
        SubarrayData leftCall = findMaximumSubarray(array, low, mid);
        SubarrayData rightCall = findMaximumSubarray(array, mid + 1, high);

        SubarrayData cross = maximumSubarrayCrossing(low, mid, high, array);

        if (leftCall.sum >= rightCall.sum && leftCall.sum >= cross.sum) {
            return leftCall;
        } else if (rightCall.sum >= leftCall.sum && rightCall.sum >= cross.sum) {
            return rightCall;
        } else {
            return cross;
        }
    }

    public static void findMaximumSubarrayLinear(int[] array) {
        int maxEndingHere = Integer.MIN_VALUE;
        int maxSoFar = Integer.MIN_VALUE;

        int low = 0;
        int high = 0;

        for (int i = 0; i < array.length; i++) {
            maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);

            if (array[i] > maxEndingHere + array[i]) {
                maxEndingHere = array[i];
                low = i;
            } else {
                maxEndingHere = maxEndingHere + array[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                high = i;
            }
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        System.out.println(String.format("Maximum : %d low: %d high: %d ", maxSoFar, low, high));
    }

    public static SubarrayData findMaximumSubarrayBruteforce(int[] array) {

        SubarrayData data = new SubarrayData(0, array.length, Integer.MIN_VALUE);

        for (int i = 0; i < array.length; i++) {
            int sum = array[i];
            for (int j = i + 1; j < array.length; j++) {

                sum += array[j];

                if (sum > data.sum) {
                    data.low = i;
                    data.high = j;
                    data.sum = sum;
                }
            }
        }

        return data;
    }


    private static SubarrayData maximumSubarrayCrossing(int low, int mid, int high, int[] array) {
        int leftSum = Integer.MIN_VALUE;

        int sum = 0;
        int maxLeft = 0;

        for (int i = mid; i >= low; i--) {
            sum += array[i];

            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        int maxRight = 0;

        for (int j = mid + 1; j < high; j++) {
            sum += array[j];

            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }

        int maxSum = leftSum + rightSum;
        //System.out.println(String.format("LeftSum: %d RightSum: %d", leftSum, rightSum));

//        System.out.println(String.format("Found max sum: %d, starting from %d to %d",
//                maxSum, maxLeft, maxRight));

        return new SubarrayData(maxLeft, maxRight, maxSum);
    }


}
