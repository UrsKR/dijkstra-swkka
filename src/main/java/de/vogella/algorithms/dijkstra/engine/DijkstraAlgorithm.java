package de.vogella.algorithms.dijkstra.engine;

import de.vogella.algorithms.dijkstra.model.Edge;
import de.vogella.algorithms.dijkstra.model.Graph;
import de.vogella.algorithms.dijkstra.model.Path;
import de.vogella.algorithms.dijkstra.model.Vertex;

import java.util.*;

public class DijkstraAlgorithm implements PathEnder, PathStarter {

  public static PathStarter FindPathInGraph(Graph graph) {
    return new DijkstraAlgorithm(graph);
  }

  private final List<Edge> edges;
  private Set<Vertex> settledNodes;
  private Set<Vertex> unSettledNodes;
  private Map<Vertex, Vertex> predecessors;
  private Map<Vertex, Integer> distance;

  private DijkstraAlgorithm(Graph graph) {
    this.edges = new ArrayList<Edge>(graph.getEdges());
  }

  public PathEnder from(Vertex source) {
    settledNodes = new HashSet<Vertex>();
    unSettledNodes = new HashSet<Vertex>();
    distance = new HashMap<Vertex, Integer>();
    predecessors = new HashMap<Vertex, Vertex>();
    distance.put(source, 0);
    unSettledNodes.add(source);
    while (unSettledNodes.size() > 0) {
      Vertex node = getMinimum(unSettledNodes);
      settledNodes.add(node);
      unSettledNodes.remove(node);
      findMinimalDistances(node);
    }
    return this;
  }

  /**
   * @return the shortest path from the source to the target or {@code null} if none.
   */
  public Path to(Vertex target) {
    LinkedList<Vertex> path = new LinkedList<Vertex>();
    Vertex step = target;
    // Check if a path exists
    if (predecessors.get(step) == null) {
      return null;
    }
    path.add(step);
    while (predecessors.get(step) != null) {
      step = predecessors.get(step);
      path.add(step);
    }
    // Put it into the correct order
    Collections.reverse(path);
    return new Path(path);
  }

  private void findMinimalDistances(Vertex node) {
    List<Vertex> adjacentNodes = getNeighbors(node);
    for (Vertex target : adjacentNodes) {
      if (getShortestDistance(target) > getShortestDistance(node)
        + getDistance(node, target)) {
        distance.put(target, getShortestDistance(node)
          + getDistance(node, target));
        predecessors.put(target, node);
        unSettledNodes.add(target);
      }
    }
  }

  private int getDistance(Vertex node, Vertex target) {
    for (Edge edge : edges) {
      if (edge.getSource().equals(node)
        && edge.getDestination().equals(target)) {
        return edge.getWeight();
      }
    }
    throw new RuntimeException("Should not happen");
  }

  private List<Vertex> getNeighbors(Vertex node) {
    List<Vertex> neighbors = new ArrayList<Vertex>();
    for (Edge edge : edges) {
      if (edge.getSource().equals(node)
        && !isSettled(edge.getDestination())) {
        neighbors.add(edge.getDestination());
      }
    }
    return neighbors;
  }

  private Vertex getMinimum(Set<Vertex> vertexes) {
    Vertex minimum = null;
    for (Vertex vertex : vertexes) {
      if (minimum == null) {
        minimum = vertex;
      } else {
        if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
          minimum = vertex;
        }
      }
    }
    return minimum;
  }

  private boolean isSettled(Vertex vertex) {
    return settledNodes.contains(vertex);
  }

  private int getShortestDistance(Vertex destination) {
    Integer d = distance.get(destination);
    if (d == null) {
      return Integer.MAX_VALUE;
    } else {
      return d;
    }
  }
}