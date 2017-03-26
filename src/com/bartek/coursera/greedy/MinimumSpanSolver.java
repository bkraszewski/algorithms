package com.bartek.coursera.greedy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * In this programming problem you'll code up Prim's minimum spanning tree algorithm.
 * <p>
 * Download the text file below.
 * <p>
 * edges.txt
 * This file describes an undirected graph with integer edge costs. It has the format
 * <p>
 * [number_of_nodes] [number_of_edges]
 * <p>
 * [one_node_of_edge_1] [other_node_of_edge_1] [edge_1_cost]
 * <p>
 * [one_node_of_edge_2] [other_node_of_edge_2] [edge_2_cost]
 * <p>
 * ...
 * <p>
 * For example, the third line of the file is "2 3 -8874", indicating that there is an edge connecting vertex #2 and vertex #3 that has cost -8874.
 * <p>
 * You should NOT assume that edge costs are positive, nor should you assume that they are distinct.
 * <p>
 * Your task is to run Prim's minimum spanning tree algorithm on this graph. You should report the overall cost of a minimum spanning tree --- an integer, which may or may not be negative --- in the box below.
 * <p>
 * IMPLEMENTATION NOTES: This graph is small enough that the straightforward O(mn) time implementation of Prim's algorithm should work fine. OPTIONAL: For those of you seeking an additional challenge,
 * try implementing a heap-based version. The simpler approach, which should already give you a healthy speed-up, is to maintain relevant edges in a heap (with keys = edge costs).
 * The superior approach stores the unprocessed vertices in the heap, as described in lecture. Note this requires a heap that supports deletions, and you'll
 * probably need to maintain some kind of mapping between vertices and their positions in the heap.
 */
public class MinimumSpanSolver {
    public static long countMinimumSpanningCost(Graph tree) {

        int first = tree.firstKey;
        System.out.println("Staring from: " + first);
        int current = first;
        long totalCost = 0;

        Set<Integer> minimumSpanningTree = new HashSet<>();
        minimumSpanningTree.add(first);
        List<Graph.Edge> options = tree.graph.get(current);

        while (minimumSpanningTree.size() != tree.vertexes) {

            int to = 0;
            long cost = Long.MAX_VALUE;
            Graph.Edge bestEdge = null;
            for (Graph.Edge edge : options) {
                if (!minimumSpanningTree.contains(edge.to) && edge.cost < cost) {
                    to = edge.to;
                    cost = edge.cost;
                    bestEdge = edge;
                }
            }

            totalCost += cost;
            options.remove(bestEdge);
            System.out.println("Choosen edge from: " + bestEdge.from + ", next path is: " + to + " with a cost: " + cost);
            minimumSpanningTree.add(to);

            if (tree.graph.get(to) != null) {
                for (Graph.Edge edge : tree.graph.get(to)) {
                    if (!options.contains(edge)) {
                        options.add(edge);
                    }
                }
//                options.addAll(tree.graph.get(to));

            }

        }

        return totalCost;
    }
}
