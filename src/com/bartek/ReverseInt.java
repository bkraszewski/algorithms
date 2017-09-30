package com.bartek;

import java.util.Stack;

public class ReverseInt {

    public static int reverse(int input) {
        int a = input;
        boolean positive = a > 0;
        a = Math.abs(a);

        Stack<Integer> stack = new Stack<>();

        while (a > 0) {
            stack.push(a % 10);
            a /= 10;
        }

        long ret = 0;
        long multiplier = 1;

        while (!stack.isEmpty()) {
            long futureRet = ret +stack.pop() * multiplier;
            if(futureRet > Integer.MAX_VALUE){
                return 0;
            }

            ret = futureRet;
            multiplier *= 10;
        }


        return ret > (long) Integer.MAX_VALUE ? 0 : (int) ret * (positive ? 1 : -1);
    }


}
