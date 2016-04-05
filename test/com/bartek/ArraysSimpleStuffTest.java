package com.bartek;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArraysSimpleStuffTest {


    @Test
    public void shouldSayTrueWhenNotUnique() {
        Assert.assertEquals(false, ArraysSimpleStuff.isUnique(new int[]{1, 1, 2, 3, 4, 5, 6}));
        Assert.assertEquals(false, ArraysSimpleStuff.isUnique(new int[]{1, 2, 2, 3, 4, 5, 6}));
        Assert.assertEquals(false, ArraysSimpleStuff.isUnique(new int[]{1, 2, 3, 3, 4, 5, 6}));
        Assert.assertEquals(false, ArraysSimpleStuff.isUnique(new int[]{1, 2, 3, 4, 4, 5, 6}));
        Assert.assertEquals(false, ArraysSimpleStuff.isUnique(new int[]{1, 2, 3, 4, 5, 5, 6}));
        Assert.assertEquals(false, ArraysSimpleStuff.isUnique(new int[]{1, 2, 3, 4, 5, 6, 6}));

        Assert.assertEquals(true, ArraysSimpleStuff.isUnique(new int[]{1}));
        Assert.assertEquals(true, ArraysSimpleStuff.isUnique(new int[]{1, 2}));
        Assert.assertEquals(true, ArraysSimpleStuff.isUnique(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    @Test
    public void shouldReplaceSpaces() {
        Assert.assertEquals("", new String(ArraysSimpleStuff.replaceSpaces("".toCharArray(), 0)));
        Assert.assertEquals("asdasda", new String(ArraysSimpleStuff.replaceSpaces("asdasda".toCharArray(), 7)));
        Assert.assertEquals("Pan%20Jan%20Nowak", new String(ArraysSimpleStuff.replaceSpaces("Pan Jan Nowak         ".toCharArray(), 13)).trim());
    }

    @Test
    public void shouldCompressString() {
        Assert.assertEquals("", ArraysSimpleStuff.compressString(""));
        try {
            ArraysSimpleStuff.compressString(null);
            Assert.fail("should throw an exception");
        } catch (IllegalArgumentException e) {
            //ignore, its ok
        }

        Assert.assertEquals("a2b3c2", ArraysSimpleStuff.compressString("aabbbcc"));
        Assert.assertEquals("abc", ArraysSimpleStuff.compressString("abc"));
        Assert.assertEquals("a2b3c2de", ArraysSimpleStuff.compressString("aabbbccde"));
        Assert.assertEquals("aabcdd", ArraysSimpleStuff.compressString("aabcdd"));
    }

    @Test
    public void shouldRotateArray90Deg() {
        char[][] matrix = {{'a', 'b', 'c', 'd',},
                {'a', 'b', 'c', 'd',},
                {'a', 'b', 'c', 'd',},
                {'a', 'b', 'c', 'd',},
        };

        matrix = ArraysSimpleStuff.rotateClocwise(matrix);

        Assert.assertArrayEquals(new char[][]{{'a', 'a', 'a', 'a',},
                {'b', 'b', 'b', 'b',},
                {'c', 'c', 'c', 'c',},
                {'d', 'd', 'd', 'd',},
        }, matrix);
    }


    @Test
    public void shouldRotateArray90DegInPlace() {
        char[][] matrix = {{'a', 'b', 'c', 'd',},
                {'a', 'b', 'c', 'd',},
                {'a', 'b', 'c', 'd',},
                {'a', 'b', 'c', 'd',},
        };

        matrix = ArraysSimpleStuff.rotateClocwiseInPlace(matrix);

        Assert.assertArrayEquals(new char[][]{{'a', 'a', 'a', 'a',},
                {'b', 'b', 'b', 'b',},
                {'c', 'c', 'c', 'c',},
                {'d', 'd', 'd', 'd',},
        }, matrix);
    }


}
