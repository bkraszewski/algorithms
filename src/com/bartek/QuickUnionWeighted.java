package com.bartek;

/**
 * Created by bartek on 31/01/16.
 */
public class QuickUnionWeighted {
    private final int[] numbers;
    private final int[] sSize;

    public QuickUnionWeighted(int n) {
        numbers = new int[n];
        sSize = new int[n];
        for (int a = 0; a < n; a++) {
            numbers[a] = a;
            sSize[a] = 1;
        }
    }

    private int root(int i) {
        while (i != numbers[i]) {
            numbers[i] = numbers[numbers[i]];
            i = numbers[i];
        }

        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void connect(int p, int q) {
        int i = root(p);
        int j = root(q);

        if(i == j){
            return;
        }

        if(sSize[i] < sSize[j]){
            numbers[i] = j;
            sSize[j] += sSize[i];
        }else{
            numbers[j] = i;
            sSize[i] += sSize[j];
        }
    }
}
