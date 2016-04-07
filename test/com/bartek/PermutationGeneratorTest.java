package com.bartek;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PermutationGeneratorTest {

    @Test
    public void shouldCreateParenthesisForOnePair(){
        List<String> results = PermutationGenerator.createParenthesisPermutation(1);
        assertTrue(results.contains("()"));
        assertEquals(1,results.size());
    }

    @Test
    public void shouldCreateParenthesisForTwoPairs(){
        List<String> results = PermutationGenerator.createParenthesisPermutation(2);
        assertTrue(results.contains("()()"));
        assertTrue(results.contains("(())"));
        assertEquals(2,results.size());
    }

    @Test
    public void shouldCreateParenthesisForMorePairs(){
        List<String> results = PermutationGenerator.createParenthesisPermutation(3);
        assertTrue(results.contains("()()()"));
        assertTrue(results.contains("(()())"));

        assertTrue(results.contains("()(())"));
        assertTrue(results.contains("((()))"));

        assertEquals(4,results.size());
    }

    @Test
    public void shouldCreatePermutationForOneLetter(){
        List<String> results = PermutationGenerator.createPermutations("a");
        assertTrue(results.contains("a"));
        assertEquals(1,results.size());
    }

    @Test
    public void shouldCreatePermutationForTwoLettesr(){
        List<String> results = PermutationGenerator.createPermutations("ab");
        System.out.println("Results for ab: " + results);
        assertTrue(results.contains("ab"));
        assertTrue(results.contains("ba"));
        assertEquals(2,results.size());
    }

    @Test
    public void shouldCreatePermutationForThreeLettesr(){
        List<String> results = PermutationGenerator.createPermutations("abc");
        System.out.println("Results for abc: " + results);
        assertTrue(results.contains("abc"));
        assertTrue(results.contains("bac"));
        assertTrue(results.contains("acb"));
        assertTrue(results.contains("bca"));
        assertTrue(results.contains("cab"));
        assertTrue(results.contains("cba"));
        assertEquals(6,results.size());
    }

}