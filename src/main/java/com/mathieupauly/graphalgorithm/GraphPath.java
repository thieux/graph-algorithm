package com.mathieupauly.graphalgorithm;

public class GraphPath {

    private final Graph g;
    private boolean found;
    private boolean[] visited;

    public GraphPath(Graph g, int v, int w) {
        this.g = g;
        visited = new boolean[g.V()];
        found = search(v, w);
    }

    public boolean exists() {
        return found;
    }

    private boolean search(int v, int w) {
        if (v == w) {
            return true;
        }
        visited[v] = true;
        Adjacencies a = g.adjacencies(v);
        for (int t = a.begin(); !a.end(); t = a.next()) {
            if (!visited[t]) {
                if (search(t, w)) {
                    return true;
                }
            }
        }
        return false;
    }


}
