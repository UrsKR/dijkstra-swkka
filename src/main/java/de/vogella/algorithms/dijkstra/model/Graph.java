package de.vogella.algorithms.dijkstra.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

  private final List<Vertex> vertexes = new ArrayList<Vertex>();
  private final List<Edge> edges = new ArrayList<Edge>();

  public void addNode() {
    String id = "Node_" + vertexes.size();
    Vertex location = new Vertex(id);
    vertexes.add(location);
  }

  public Vertex getNode(int number) {
    return vertexes.get(number);
  }

  public void addEdge(Vertex source, Vertex destination, int duration) {
    String id = "Edge_" + edges.size();
    Edge edge = new Edge(id, source, destination, duration);
    edges.add(edge);
  }

  public List<Edge> getEdges() {
    return edges;
  }
}