package com.bartek.coursera.greedy;

public class Job {
    public final double weight;
    public final double length;

    public final double ratio;

    public Job(double weight, double length) {
        this.weight = weight;
        this.length = length;

        ratio = weight / length;
    }
}
