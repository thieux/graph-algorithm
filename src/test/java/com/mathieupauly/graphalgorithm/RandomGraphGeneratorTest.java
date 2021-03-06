package com.mathieupauly.graphalgorithm;

import org.junit.Test;

public class RandomGraphGeneratorTest {

    @Test
    public void generateRandomly() {
        final RandomGraphGenerator randomGraphGenerator = new RandomGraphGenerator();
        final Graph g = new Graph(10, true);

        randomGraphGenerator.generate(g, 20);
        GraphIo.show(g);
    }
}