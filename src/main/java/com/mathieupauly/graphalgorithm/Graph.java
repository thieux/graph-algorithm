package com.mathieupauly.graphalgorithm;

public class Graph {
    private final int vertices;
    private final boolean isDirected;
    private final boolean[][] adjacencyMatrix;
    private int edges;

    public Graph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;

        edges = 0;
        adjacencyMatrix = new boolean[vertices][vertices];
    }

    public int V() {
        return vertices;
    }

    public int E() {
        return edges;
    }

    public void insert(Edge e) {
        final int v = e.v;
        final int w = e.w;

        if (!adjacencyMatrix[v][w]) {
            edges++;
        }

        adjacencyMatrix[v][w] = true;

        if (!isDirected) {
            adjacencyMatrix[w][v] = true;
        }
    }

    public void remove(Edge e) {
        final int v = e.v;
        final int w = e.w;

        if (adjacencyMatrix[v][w]) {
            edges--;
        }

        adjacencyMatrix[v][w] = false;

        if (!isDirected) {
            adjacencyMatrix[w][v] = false;
        }
    }

    public boolean edge(int v, int w) {
        return adjacencyMatrix[v][w];
    }

    public Adjacencies adjacencies(int v) {
        return new ArrayAdjencies(v);
    }

    private class ArrayAdjencies implements Adjacencies {

        private int i;
        private int v;

        ArrayAdjencies(int v) {
            this.v = v;
            i = -1;
        }

        @Override
        public int begin() {
            i = -1;

            return next();
        }

        @Override
        public int next() {
            for (i++; i < V(); i++) {
                if (edge(v, i)) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public boolean end() {
            return i >= V();
        }
    }
}
