package de.vogella.algorithms.dijkstra.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private final List<Vertex> vertexes  = new ArrayList<Vertex>();
	private final List<Edge> edges;

	public Graph(List<Edge> edges) {
		this.edges = edges;
	}

  public List<Edge> getEdges() {
		return edges;
	}

  public void addNode(Vertex location) {
    vertexes.add(location);
  }

  public Vertex getNode(int number) {
    return vertexes.get(number);
  }
}