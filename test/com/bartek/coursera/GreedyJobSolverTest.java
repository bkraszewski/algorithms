package com.bartek.coursera;

import com.bartek.coursera.greedy.GreedyDataReader;
import com.bartek.coursera.greedy.GreedyJobsSolver;
import com.bartek.coursera.greedy.Job;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class GreedyJobSolverTest {


    @Test
    public void shouldCalculateSumFor3InputsSubstract() throws IOException {

        List<Job> jobs = GreedyDataReader.readFile("./data/greedy/3.txt");
        Assert.assertEquals(10, GreedyJobsSolver.calculateJobsTimeSumForSubstracting(jobs));
    }

    @Test
    public void shouldCalculateSumFor12InputsSubstract() throws IOException {

        List<Job> jobs = GreedyDataReader.readFile("./data/greedy/12.txt");
        Assert.assertEquals(68615, GreedyJobsSolver.calculateJobsTimeSumForSubstracting(jobs));
    }

    @Test
    public void shouldCalculateSumFor1000InputsSubstract() throws IOException {

        List<Job> jobs = GreedyDataReader.readFile("./data/greedy/1000.txt");
        Assert.assertEquals(69119377652L, GreedyJobsSolver.calculateJobsTimeSumForSubstracting(jobs));
    }

    @Test
    public void shouldCalculateSumFor12InputsRatio() throws IOException {

        List<Job> jobs = GreedyDataReader.readFile("./data/greedy/12.txt");
        Assert.assertEquals(67247, GreedyJobsSolver.calculateJobsTimeSumForRatio(jobs));
    }

    @Test
    public void shouldCalculateSumFor1000InputsRatio() throws IOException {

        List<Job> jobs = GreedyDataReader.readFile("./data/greedy/1000.txt");
        Assert.assertEquals(67311454237L, GreedyJobsSolver.calculateJobsTimeSumForRatio(jobs));
    }
}
