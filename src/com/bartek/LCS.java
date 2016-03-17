package com.bartek;

public class LCS {
    public static String lcs(String first, String second) {
//        return "";

        int m = first.length() + 1;
        int n = second.length() + 1;

        int[][] c = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    // \
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i -1][j];
                    // |
                } else {
                    c[i][j] = c[i ][j - 1];
                    // <-
                }
            }
        }

        printTable(c);
        System.out.println("#######");
        StringBuilder builder = printLcs(c, first, m - 1, n - 1, new StringBuilder());
        return builder.reverse().toString();
    }

    private static void printTable(int[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j]);
            }
            System.out.println("");
        }
    }

    public static StringBuilder printLcs(int[][] c, String first, int i, int j, StringBuilder builder) {

        if (i == 0 || j == 0) {
            return builder;
        }

        if (c[i][j] == c[i - 1][j]) {
            return printLcs(c, first, i - 1, j, builder);
            // |

        } else if (c[i][j] == c[i][j - 1]) {
            return printLcs(c, first, i , j-1, builder);
            // <-
        } else {
            // \
            System.out.print(first.charAt(i - 1));
            builder.append(first.charAt(i - 1));
            return printLcs(c, first, i - 1, j - 1, builder);

        }

    }
}
