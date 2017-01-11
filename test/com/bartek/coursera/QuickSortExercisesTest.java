package com.bartek.coursera;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class QuickSortExercisesTest {

    //    Answers are:
//
//    size first last median
//    10 25 29 21
//
//    100 615 587 518
//
//    1000 10297 10184 8921
    @Test
    public void shouldHandle10IntegersLast() {
        int[] array = readFile("./data/10.txt");
        Assert.assertEquals(29, QuickSortExercises.quickSortSelectLast(array));
    }

    @Test
    public void shouldHandle10IntegersFirst() {
        int[] array = readFile("./data/10.txt");
        Assert.assertEquals(25, QuickSortExercises.quickSortSelectFirst(array));
    }

    @Test
    public void shouldHandle10IntegerMedian() {
        int[] array = readFile("./data/10.txt");
        Assert.assertEquals(21, QuickSortExercises.quickSortSelectMedian(array));
    }

    private int[] readFile(String s) {
        MyFileReader reader = new MyFileReader();
        try {
            return reader.readFromFile(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return null;
    }
}
