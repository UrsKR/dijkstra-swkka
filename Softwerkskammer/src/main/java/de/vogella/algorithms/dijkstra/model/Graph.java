package de.vogella.algorithms.dijkstra.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Edge> edges = new ArrayList<Edge>();

    public List<Edge> getEdges() {
        return edges;
    }

    public void addLane(Node source, Node destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    public Node createNode(int i) {
        return new Node("Node_" + i);
    }
}