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
    public void testExecute() {
        Node firstNode = graph.addNode(0);
        Node secondNode = graph.addNode(1);
        Node thirdNode = graph.addNode(2);
        Node fourthNode = graph.addNode(3);
        Node fifthNode = graph.addNode(4);
        Node sixthNode = graph.addNode(5);
        Node seventhNode = graph.addNode(6);
        Node eighthNode = graph.addNode(7);
        Node ninthNode = graph.addNode(8);
        Node tenthNode = graph.addNode(9);
        Node eleventhNode = graph.addNode(10);

        graph.addLane(firstNode, secondNode, 85);
        graph.addLane(firstNode, thirdNode, 217);
        graph.addLane(firstNode, fifthNode, 173);
        graph.addLane(thirdNode, seventhNode, 186);
        graph.addLane(thirdNode, eighthNode, 103);
        graph.addLane(fourthNode, eighthNode, 183);
        graph.addLane(sixthNode, ninthNode, 250);
        graph.addLane(ninthNode, tenthNode, 84);
        graph.addLane(eighthNode, tenthNode, 167);
        graph.addLane(fifthNode, tenthNode, 502);
        graph.addLane(tenthNode, eleventhNode, 40);
        graph.addLane(secondNode, eleventhNode, 600);

        // Lets check from location Loc_1 to Loc_10
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(firstNode);
        LinkedList<Node> path = dijkstra.getPath(eleventhNode);

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Node node : path) {
            System.out.println(node);
        }
    }
}