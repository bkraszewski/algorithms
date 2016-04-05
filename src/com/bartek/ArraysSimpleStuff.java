package com.bartek;

import java.util.HashSet;
import java.util.Set;

public class ArraysSimpleStuff {
    public static boolean isUnique(int[] array) {

        Set<Integer> previous = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (previous.contains(array[i])) {
                return false;
            }

            previous.add(array[i]);
        }

        return true;
    }

    public static char[] replaceSpaces(char[] items, int size) {
        final char[] SPACE = {'%', '2', '0'};
        int index = 0;

        while (index < size) {
            if (items[index] == ' ') {
                int move = SPACE.length;

                for (int i = size; i > index; i--) {
                    items[i + move - 1] = items[i];
                }

                for (int i = 0; i < move; i++) {
                    items[index + i] = SPACE[i];
                }

                index += move;
                size += move - 1;
            } else {
                index++;
            }

            System.out.println(new String(items) + " " + size);
        }

        return items;
    }

    public static String compressString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cant be null");
        }

        if (input.isEmpty()) {
            return input;
        }

        int currentCount = 1;
        StringBuilder builder = new StringBuilder(input.substring(0, 1));

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                if (currentCount == 1) {
                    builder.append(++currentCount);
                } else {
                    builder.setCharAt(builder.length() - 1, (char) (++currentCount + 48));
                }
            } else {
                builder.append(input.charAt(i));
                currentCount = 1;
            }

            System.out.print(builder.toString() + " ");
        }

        if (builder.length() == input.length()) {
            return input;
        }

        return builder.toString();
    }

    public static char[][] rotateClocwise(char[][] matrix) {
        int n = matrix.length;
        char[][] target = new char[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                target[j][i] = matrix[i][j];
            }
        }

        printArray(matrix, target);

        return target;
    }

    private static void printArray(char[][] matrix, char[][] target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(String.format("[%c],", target[i][j]));
            }

            System.out.println();
        }
    }

    public static char[][] rotateClocwiseInPlace(char[][] source) {
        int n = source.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                char top = source[first][i];

                source[first][i] = source[last - offset][first];

                source[last - offset][first] = source[last][last - offset];

                source[last][last - offset] = source[i][last];

                source[i][last] = top;
            }
        }
        return source;
    }


}
