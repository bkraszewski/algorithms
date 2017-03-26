package com.bartek.coursera.greedy;

import java.util.*;

public class Graph {
    public final int vertexes;
    public final int edges;

    public final Map<Integer, List<Edge>> graph = new HashMap<>();
    public final int firstKey;

    public Graph(int vertexes, int edges, List<String> edgeInfo) {

        this.vertexes = vertexes;
        this.edges = edges;

        int first = Integer.MIN_VALUE;

        for (String edge : edgeInfo) {
            String[] info = edge.split("\\s+");
            if (info.length != 3) {
                throw new IllegalArgumentException("should have 3args");
            }

            int key = Integer.valueOf(info[0]);

            if (first == Integer.MIN_VALUE) {
                first = key;
            }


            Edge edge1 = new Edge(key, Integer.valueOf(info[1]), Long.valueOf(info[2]));
            addEdge(key, edge1);

            Edge reversed = edge1.reversed();
            addEdge(reversed.from, reversed);
        }

        this.firstKey = first;
    }

    private boolean alreadyExists(Edge reversed) {
        if (graph.get(reversed.from) == null || !graph.get(reversed.from).contains(reversed)) {
            return false;
        }

        return true;
    }

    private void addEdge(int key, Edge edge) {
        if (graph.get(key) == null) {
            //TODO replace with sorted set
            graph.put(key, new ArrayList<>());
        }

        if (!alreadyExists(edge)) {
            graph.get(key).add(edge);
        }
    }

    public static class Edge {
        public final int from;
        public final int to;
        public final long cost;


        public Edge(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public Edge reversed() {
            return new Edge(to, from, cost);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;

            Edge edge = (Edge) o;

            if (from != edge.from) return false;
            if (to != edge.to) return false;
            return cost == edge.cost;
        }

        @Override
        public int hashCode() {
            int result = from;
            result = 31 * result + to;
            result = 31 * result + (int) (cost ^ (cost >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", cost=" + cost +
                    '}';
        }


    }
}
