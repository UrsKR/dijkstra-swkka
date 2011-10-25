package de.vogella.algorithms.dijkstra.model;

public class Edge {

  private final Node source;
  private final Node destination;
  private final int weight;

  public Edge(Node source, Node destination, int weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }

  public Node getDestination() {
    return destination;
  }

  public int getWeight() {
    return weight;
  }

  boolean connects(Node node, Node target) {
    this.source == node && this.destination == target
  }

  boolean startsAt(Node node) {
    return source.equals(node)
  }

  @Override
  public String toString() {
    return source + " " + destination;
  }
}