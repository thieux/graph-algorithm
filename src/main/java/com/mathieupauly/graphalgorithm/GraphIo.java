package com.mathieupauly.graphalgorithm;

public class GraphIo {
    public static void show(Graph g) {
        for (int s = 0; s < g.V(); s++) {
            System.out.format("%d: ", s);

            final Adjacencies adjacencies = g.adjacencies(s);
            for (int t = adjacencies.begin(); !adjacencies.end(); t = adjacencies.next()) {
                System.out.format("%d ", t);
            }
            System.out.println();
        }
    }
}
