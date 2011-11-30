package de.vogella.algorithms.dijkstra.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import de.vogella.algorithms.dijkstra.engine.DijkstraAlgorithm;
import de.vogella.algorithms.dijkstra.model.Edge;
import de.vogella.algorithms.dijkstra.model.Graph;
import de.vogella.algorithms.dijkstra.model.Vertex;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestDijkstraAlgorithm {

    private Graph graph = new Graph();

    @Test
    public void testExcute() {
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            graph.getVertexes().add(location);
        }

        addLane(0, 1, 85);
        addLane(0, 2, 217);
        addLane(0, 4, 173);
        addLane(2, 6, 186);
        addLane(2, 7, 103);
        addLane(3, 7, 183);
        addLane(5, 8, 250);
        addLane(8, 9, 84);
        addLane(7, 9, 167);
        addLane(4, 9, 502);
        addLane(9, 10, 40);
        addLane(1, 10, 600);

        // Lets check from location Loc_1 to Loc_10
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(graph.getVertexes().get(0));
        LinkedList<Vertex> path = dijkstra.getPath(graph.getVertexes().get(10));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }

    }

    private void addLane(int sourceLocNo, int destLocNo, int duration) {
        Edge lane = new Edge(graph.getVertexes().get(sourceLocNo), graph.getVertexes().get(destLocNo), duration);
        graph.getEdges().add(lane);
    }
}
