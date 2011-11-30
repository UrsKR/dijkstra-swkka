package de.vogella.algorithms.dijkstra.test;

import java.util.LinkedList;

import org.junit.Test;

import de.vogella.algorithms.dijkstra.engine.DijkstraAlgorithm;
import de.vogella.algorithms.dijkstra.model.Graph;
import de.vogella.algorithms.dijkstra.model.Node;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestDijkstraAlgorithm {

    private Graph graph = new Graph();

    @Test
    public void testExcute() {
        for (int i = 0; i < 11; i++) {
            graph.addNode(i);
        }

        graph.addLane(graph.getNodes().get(0), graph.getNodes().get(1), 85);
        graph.addLane(graph.getNodes().get(0), graph.getNodes().get(2), 217);
        graph.addLane(graph.getNodes().get(0), graph.getNodes().get(4), 173);
        graph.addLane(graph.getNodes().get(2), graph.getNodes().get(6), 186);
        graph.addLane(graph.getNodes().get(2), graph.getNodes().get(7), 103);
        graph.addLane(graph.getNodes().get(3), graph.getNodes().get(7), 183);
        graph.addLane(graph.getNodes().get(5), graph.getNodes().get(8), 250);
        graph.addLane(graph.getNodes().get(8), graph.getNodes().get(9), 84);
        graph.addLane(graph.getNodes().get(7), graph.getNodes().get(9), 167);
        graph.addLane(graph.getNodes().get(4), graph.getNodes().get(9), 502);
        graph.addLane(graph.getNodes().get(9), graph.getNodes().get(10), 40);
        graph.addLane(graph.getNodes().get(1), graph.getNodes().get(10), 600);

        // Lets check from location Loc_1 to Loc_10
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(graph.getNodes().get(0));
        LinkedList<Node> path = dijkstra.getPath(graph.getNodes().get(10));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Node node : path) {
            System.out.println(node);
        }
    }
}