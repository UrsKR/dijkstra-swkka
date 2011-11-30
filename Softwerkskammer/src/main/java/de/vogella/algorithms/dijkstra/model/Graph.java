package de.vogella.algorithms.dijkstra.model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> vertexes = new ArrayList<Vertex>();
    private List<Edge> edges = new ArrayList<Edge>();

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }


}