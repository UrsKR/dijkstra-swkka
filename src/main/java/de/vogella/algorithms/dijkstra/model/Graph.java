package de.vogella.algorithms.dijkstra.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

  private final List<Node> nodes = new ArrayList<Node>();
  private final List<Edge> edges = new ArrayList<Edge>();

  public void addNode() {
    String id = "Node_" + nodes.size();
    Node location = new Node(id);
    nodes.add(location);
  }

  public Node getNode(int number) {
    return nodes.get(number);
  }

  public void addEdge(Node source, Node destination, int duration) {
    Edge edge = new Edge(source, destination, duration);
    edges.add(edge);
  }

  public List<Edge> getEdges() {
    return edges;
  }
}