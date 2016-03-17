package com.bartek;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LCSTest {

    @Test
    public void shouldReturnEmptyString() {
        String result = LCS.lcs("", "");
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnA(){
        String result = LCS.lcs("A", "A");
        assertEquals("A", result);
    }

    @Test
    public void shouldReturnBCBA(){
        String result = LCS.lcs("ABCBDAB", "BDCABA");
        assertEquals("BCBA", result);
    }
}
