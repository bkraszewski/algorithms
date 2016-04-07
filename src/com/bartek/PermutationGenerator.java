package com.bartek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationGenerator {
    public static List<String> createPermutations(String abc) {
        return createPermutations(abc, abc.length(), new ArrayList<>());
    }

    private static List<String> createPermutations(String input, int length, List<String> strings) {
        if (length == 0) {
            return Collections.emptyList();
        }

        if (length == 1) {
            strings.add(input.substring(length - 1, length));
            return strings;
        }

        strings = createPermutations(input, length - 1, strings);
        List<String> tempValues = new ArrayList<>();
        for (String prev : strings) {
            for (int i = 0; i <= prev.length(); i++) {
                StringBuilder builder = new StringBuilder(prev);
                builder.insert(i, input.substring(length - 1, length));
                tempValues.add(builder.toString());
            }
        }

        return tempValues;
    }

    private static List<String> createParenthesisPermutation(int pairs, List<String> tempResults) {
        if (pairs == 0) {
            return Collections.emptyList();
        }

        if (pairs == 1) {
            tempResults.add("()");
            return tempResults;
        }

        tempResults = createParenthesisPermutation(pairs - 1, tempResults);
        List<String> results = new ArrayList<>();
        for (String permutations : tempResults) {
            results.add("()" + permutations);
            results.add("(" + permutations + ")");
        }

        return results;
    }

    public static List<String> createParenthesisPermutation(int pairs) {
        return createParenthesisPermutation(pairs, new ArrayList<>());
    }
}
