package de.vogella.algorithms.dijkstra.test;

import de.vogella.algorithms.dijkstra.engine.DijkstraAlgorithm;
import de.vogella.algorithms.dijkstra.model.Graph;
import de.vogella.algorithms.dijkstra.model.Node;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestDijkstraAlgorithm {

    private Graph graph = new Graph();

    @Test
    public void findsShortestPath() {
        Node firstNode = graph.createNode(0);
        Node secondNode = graph.createNode(1);
        Node thirdNode = graph.createNode(2);
        Node fourthNode = graph.createNode(3);
        Node fifthNode = graph.createNode(4);
        Node sixthNode = graph.createNode(5);
        Node seventhNode = graph.createNode(6);
        Node eighthNode = graph.createNode(7);
        Node ninthNode = graph.createNode(8);
        Node tenthNode = graph.createNode(9);
        Node eleventhNode = graph.createNode(10);

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

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(firstNode);
        List<Node> path = dijkstra.getPath(eleventhNode);

        assertThat(path, is(asList(firstNode, thirdNode, eighthNode, tenthNode, eleventhNode)));
    }
}