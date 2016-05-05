package com.bartek;

import java.util.ArrayList;

public class PlaceQueens {

    public final static int GRID_SIZE = 8;
    public static int numberOfCalls = 0;

    public static void place(int row, Integer[] columns, ArrayList<Integer[]> results){
        numberOfCalls++;

        if(row == GRID_SIZE){
            results.add(columns.clone());
        }else{
            for(int col = 0; col< GRID_SIZE; col++){
                if(checkValid(columns, row, col)){
                    columns[row] = col;
                    place(row +1, columns, results);
                }
            }
        }
    }

    private static boolean checkValid(Integer[] columns, int row1, int col1){
        for( int row2 = 0; row2 < row1; row2++){
            int column2 = columns[row2];

            if(column2 == col1){
                return false;
            }

            int columnDistance = Math.abs(column2 - col1);
            int rowDistance = row1 - row2;

            if(rowDistance == columnDistance){
                return false;
            }
        }

        return true;
    }
}
