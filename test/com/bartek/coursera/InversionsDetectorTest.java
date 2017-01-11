package com.bartek.coursera;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class InversionsDetectorTest {

    @Test
    public void shouldCountInversions() {
        Assert.assertEquals(1, InversionsDetector.countInversions(new int[]{1, 2, 3, 5, 4}));

    }

    @Test
    public void shouldCOuntInversionsToo() {
        Assert.assertEquals(5, InversionsDetector.countInversions(new int[]{1, 20, 6, 4, 5}));
    }

    @Test
    public void shouldCountThisOneToo() {
        Assert.assertEquals(19, InversionsDetector.countInversions(new int[]{1, 2, 5, 6, 4, 9, 8, 3, 7, 0}));
    }

    @Test
    public void shouldSolveCourseraProblem() {

        int[] input = new int[0];
        try {
            input = readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("File loading failed");

        }
        System.out.println(InversionsDetector.countInversions(input));
        assertTrue(true);
    }

    private int[] readFromFile() throws FileNotFoundException {
        BufferedReader stream = null;
        try {
            stream = new BufferedReader(new FileReader("./data/array.txt"));
            return stream.lines().mapToInt(Integer::parseInt)
                    .toArray();


        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
