package com.bartek;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PlaceQueensTest {

    @Test
    public void shouldPlaceQueensUnique(){
        ArrayList<Integer[]> results = new ArrayList<>();
        PlaceQueens.place(0, new Integer[8], results);

        StringBuilder builder = new StringBuilder();

        for(Integer[] res: results){
            builder.append(Arrays.toString(res));
            builder.append("\n");
        }

        System.out.println(builder);
    }

}