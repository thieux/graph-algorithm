package com.mathieupauly.graphalgorithm;

public class RandomGraphGenerator {

    public void generate(Graph g, int e) {
        for (int i = 0; i < e; i++) {
            int v = (int) (g.V() * Math.random());
            int w = (int) (g.V() * Math.random());

            g.insert(new Edge(v, w));
        }
    }
}
