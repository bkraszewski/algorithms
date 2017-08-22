package com.bartek.coursera.greedy;

import java.util.*;

public class Graph {
    public final int vertexes;
    public final int edges;

    public final Map<Integer, Set<Edge>> graph;
    public final int firstKey;

    private Graph(int vertexes, int edges, Map<Integer, Set<Edge>> edgeInfo) {
        this.vertexes = vertexes;
        this.edges = edges;
        this.graph = edgeInfo;
        this.firstKey = graph.keySet().stream().findAny().get();
    }

    public Graph(int vertexes, int edges, List<String> edgeInfo) {

        this.vertexes = vertexes;
        this.edges = edges;
        this.graph = new HashMap<>();

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

    public Graph removeReversedEdges() {
        HashMap<Integer, Set<Edge>> graphCopy = new HashMap<>(graph);
        for (Set<Edge> edges : graphCopy.values()) {
            for (Iterator<Edge> it = edges.iterator(); it.hasNext(); ) {
                Edge edge = it.next();
                if (edgeExistsAsReversed(edge, edges)) {
                    it.remove();
                }
            }
        }

        return new Graph(vertexes, edges, graphCopy);
    }

    private boolean edgeExistsAsReversed(Edge edge, Set<Edge> edges) {
        return edges.stream().anyMatch(edge1 -> edge.isReversed(edge));
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
            graph.put(key, new HashSet<>());
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
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }

        public boolean isReversed(Edge edge) {
            return (cost == edge.cost && from == edge.to && to == edge.from);
        }
    }
}
