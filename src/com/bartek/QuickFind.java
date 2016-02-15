package com.bartek;

/**
 * Created by bartek on 31/01/16.
 */
public class QuickFind {
    private final int[] numbers;

    public QuickFind(int n) {
        numbers = new int[n];

        for (int a = 0; a < n; a++) {
            numbers[a] = a;
        }
    }

    public boolean isConnected(int p, int q) {
        return numbers[p] == numbers[q];
    }

    public void connect(int p, int q) {
        int oldValue = numbers[p];

        for (int a = 0; a < numbers.length; a++) {
            if (numbers[a] == oldValue) {
                numbers[a] = numbers[q];
            }
        }
    }
}
