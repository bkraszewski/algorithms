package com.bartek;

/**
 * Created by bartek on 31/01/16.
 */
public class QuickUnion {
    private final int[] numbers;

    public QuickUnion(int n) {
        numbers = new int[n];

        for (int a = 0; a < n; a++) {
            numbers[a] = a;
        }
    }

    private int root(int i) {
        while (i != numbers[i]) {
            i = numbers[i];
        }

        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void connect(int p, int q) {
        int pRoot = root(p);
        numbers[pRoot] = root(q);
    }
}
