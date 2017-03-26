package com.bartek.coursera;

import com.bartek.coursera.greedy.Graph;
import com.bartek.coursera.greedy.GreedyDataReader;
import com.bartek.coursera.greedy.MinimumSpanSolver;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class MinimumSpanSolverTest {

    @Test
    public void shouldSolveSmallSpanningTree() throws IOException {
        Graph tree  = GreedyDataReader.readGraph("./data/greedy/spanning_small.txt");
        Assert.assertEquals(7, MinimumSpanSolver.countMinimumSpanningCost(tree));
    }

    @Test
    public void shouldSolveSmallSpanningTreeV2() throws IOException {
        Graph tree  = GreedyDataReader.readGraph("./data/greedy/spanning_small_v2.txt");
        Assert.assertEquals(18, MinimumSpanSolver.countMinimumSpanningCost(tree));
    }

    @Test
    public void shouldSolveSmallSpanningTreeV3() throws IOException {
        Graph tree  = GreedyDataReader.readGraph("./data/greedy/spanning_small_v3.txt");
        Assert.assertEquals(37, MinimumSpanSolver.countMinimumSpanningCost(tree));
    }

    @Test
    public void shouldSolveFullSpanningTree() throws IOException {
        Graph tree  = GreedyDataReader.readGraph("./data/greedy/spanning_full.txt");
        Assert.assertEquals(-3612829, MinimumSpanSolver.countMinimumSpanningCost(tree));
    }
}
