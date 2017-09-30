package com.bartek;

import com.bartek.coursera.IntegerMultiply;

import java.util.ArrayList;
import java.util.LinkedList;

public class PascalTriangle {
    public static ArrayList<ArrayList<Integer>> create(int rows) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        for (int a = 0; a < rows; a++) {
            ArrayList<Integer> arr = (new ArrayList<>());
            arr.add(1);
            ret.add(arr);
        }

        for (int a = 1; a < rows; a++) {
            for (int b = 1; b < rows; b++) {
                if (!topExists(a - 1, b, ret)) {
                    ret.get(a).add(1);
                    break;
                } else {
                    int prev = ret.get(a - 1).get(b - 1);
                    int top = ret.get(a - 1).get(b);
                    ret.get(a).add(prev + top);
                }
            }
        }

        return ret;
    }

    private static boolean topExists(int x, int y, ArrayList<ArrayList<Integer>> ret) {
        return (x >= 0 && x < ret.size() && y >= 0 && y < ret.get(x).size());
    }

    public static void main(String args[]) {
        System.out.println(create(5));
    }
}
