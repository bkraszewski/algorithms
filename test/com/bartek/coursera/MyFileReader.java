package com.bartek.coursera;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileReader {
    public int[] readFromFile(String path) throws FileNotFoundException {
        BufferedReader stream = null;
        try {
            stream = new BufferedReader(new java.io.FileReader(path));
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
