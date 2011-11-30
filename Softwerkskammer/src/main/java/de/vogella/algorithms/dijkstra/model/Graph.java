package de.vogella.algorithms.dijkstra.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes = new ArrayList<Node>();
    private List<Edge> edges = new ArrayList<Edge>();

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addLane(Node source, Node destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    public Node addNode(int i) {
        Node node = new Node("Node_" + i);
        nodes.add(node);
        return node;
    }
}