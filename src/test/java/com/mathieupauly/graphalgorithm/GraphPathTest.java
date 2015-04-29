package com.mathieupauly.graphalgorithm;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphPathTest {

    @Test
    public void path() {
        final Graph graph = new Graph(3, true);
        graph.insert(new Edge(0, 1));
        graph.insert(new Edge(1, 2));

        final GraphPath graphPath = new GraphPath(graph, 0, 2);

        assertTrue(graphPath.exists());
    }

    @Test
    public void noPath() {
        final Graph graph = new Graph(3, true);
        graph.insert(new Edge(1, 0));
        graph.insert(new Edge(1, 2));

        final GraphPath graphPath = new GraphPath(graph, 0, 2);

        assertFalse(graphPath.exists());
    }

}