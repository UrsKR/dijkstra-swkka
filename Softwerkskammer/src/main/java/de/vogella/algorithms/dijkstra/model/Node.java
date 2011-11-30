package de.vogella.algorithms.dijkstra.model;

public class Node {
    final private String name;


    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}