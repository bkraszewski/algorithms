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
    public void shouldHandle100IntegersLast() {
        int[] array = readFile("./data/100.txt");
        Assert.assertEquals(587, QuickSortExercises.quickSortSelectLast(array));
    }

    @Test
    public void shouldHandle1000IntegersLast() {
        int[] array = readFile("./data/1000.txt");
        Assert.assertEquals(10184, QuickSortExercises.quickSortSelectLast(array));
    }

    @Test
    public void shouldHandle10IntegersFirst() {
        int[] array = readFile("./data/10.txt");
        Assert.assertEquals(25, QuickSortExercises.quickSortSelectFirst(array));
    }

    @Test
    public void shouldHandle100IntegersFirst() {
        int[] array = readFile("./data/100.txt");
        Assert.assertEquals(615, QuickSortExercises.quickSortSelectFirst(array));
    }

    @Test
    public void shouldHandle1000IntegersFirst() {
        int[] array = readFile("./data/1000.txt");
        Assert.assertEquals(10297, QuickSortExercises.quickSortSelectFirst(array));
    }

    @Test
    public void shouldHandle10IntegerMedian() {
        int[] array = readFile("./data/10.txt");
        Assert.assertEquals(21, QuickSortExercises.quickSortSelectMedian(array));
    }

    @Test
    public void shouldHandle100IntegerMedian() {
        int[] array = readFile("./data/100.txt");
        Assert.assertEquals(518, QuickSortExercises.quickSortSelectMedian(array));
    }

    @Test
    public void shouldHandle1000IntegerMedian() {
        int[] array = readFile("./data/1000.txt");
        Assert.assertEquals(8921, QuickSortExercises.quickSortSelectMedian(array));
    }

    @Test
    public void shouldCalculate10000ForFirst(){
        int[] array = readFile("./data/quicksort.txt");
        System.out.println(QuickSortExercises.quickSortSelectFirst(array));
    }

    @Test
    public void shouldCalculate10000ForLast(){
        int[] array = readFile("./data/quicksort.txt");
        System.out.println(QuickSortExercises.quickSortSelectLast(array));
    }

    @Test
    public void shouldCalculate10000ForMedium(){
        int[] array = readFile("./data/quicksort.txt");
        System.out.println(QuickSortExercises.quickSortSelectMedian(array));
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
