package com.bartek;

import java.util.BitSet;

public class BitTest {
    public static long countOnes(long number) {
        if (number == 0) {
            return 0;
        }

        long currentNumber = getLargesPower(number);

        long total = number;
        long ones = 0;

        while(total > 0 && currentNumber > 0){
            if(total / currentNumber > 0){
                ones++;
                if(total >= currentNumber) {
                    total -= currentNumber;
                }
            }

            currentNumber /= 2;
        }

        System.out.println("Current number is: " + currentNumber);
        System.out.println("Number of ones: "+ ones +" for number: "+number);
        return ones;
    }

    private static long getLargesPower(long number) {
        long currentNumber = 1;
        while (true) {
            long next = currentNumber * 2;

            if (next <= number) {
                currentNumber = next;
                continue;
            } else {
                return currentNumber;
            }
        }
    }

    public static void main(String[] args) {
        countOnes(111593685);
//        countOnes(1);
//        countOnes(7);
//        countOnes(8);
    }
}
