package de.vogella.algorithms.dijkstra.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

  private final List<Vertex> vertexes = new ArrayList<Vertex>();
  private final List<Edge> edges = new ArrayList<Edge>();

  public List<Edge> getEdges() {
    return edges;
  }

  public void addNode() {
    Vertex location = new Vertex("Node_" + vertexes.size());
    vertexes.add(location);
  }

  public Vertex getNode(int number) {
    return vertexes.get(number);
  }
}