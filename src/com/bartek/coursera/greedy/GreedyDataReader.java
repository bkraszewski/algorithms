package com.bartek.coursera.greedy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class GreedyDataReader {
    public static List<Job> readFile(String path) throws IOException {
        BufferedReader stream = null;
        try {
            stream = new BufferedReader(new java.io.FileReader(path));
            String size = stream.readLine();

            return stream
                    .lines()
                    .map(GreedyDataReader::readJob)
                    .filter(job -> job != null)
                    .collect(Collectors.toList());


        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Job readJob(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String[] array = input.split("\\s+");
        if (array.length != 2) {
            throw new IllegalArgumentException("Invalid data format, should be 2 parts separated by whitespace");
        }

        return new Job(Double.valueOf(array[0]), Double.valueOf(array[1]));

    }

    public static Graph readGraph(String path) throws IOException {
        BufferedReader stream = null;
        int vertexes = 0;
        int edges = 0;
        try {
            stream = new BufferedReader(new java.io.FileReader(path));
            String size = stream.readLine();
            String[] sizeInfo = size.split("\\s+");
            vertexes = Integer.valueOf(sizeInfo[0]);
            if (sizeInfo.length > 1) {
                edges = Integer.valueOf(sizeInfo[1]);
            }

            List<String> lines = stream
                    .lines()
                    .filter(line -> line != null && !line.isEmpty())
                    .collect(Collectors.toList());
            return new Graph(vertexes, edges, lines);


        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
