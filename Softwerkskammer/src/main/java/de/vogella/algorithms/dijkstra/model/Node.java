package de.vogella.algorithms.dijkstra.model;

import de.vogella.algorithms.dijkstra.engine.DijkstraAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Node {
    final private String name;


    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Node> getNeighbours(List<Edge> edges) {
        List<Node> neighbors = new ArrayList<Node>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(this)) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }
}