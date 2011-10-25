package de.vogella.algorithms.dijkstra.engine;


import de.vogella.algorithms.dijkstra.model.Edge
import de.vogella.algorithms.dijkstra.model.Graph
import de.vogella.algorithms.dijkstra.model.Node
import de.vogella.algorithms.dijkstra.model.Path

public class DijkstraAlgorithm implements PathEnder, PathStarter {

  public static PathStarter FindPathInGraph(Graph graph) {
    return new DijkstraAlgorithm(graph);
  }

  private final Set<Node> settledNodes = new HashSet<Node>();
  private final Set<Node> unSettledNodes = new HashSet<Node>();
  private final Map<Node, Node> predecessors= new HashMap<Node, Node>();
  private final Map<Node, Integer> distance= new HashMap<Node, Integer>();
  private final Graph graph

  private DijkstraAlgorithm(Graph graph) {
    this.graph = graph;
  }

  public PathEnder from(Node source) {
    distance.put(source, 0);
    unSettledNodes.add(source);
    while (unSettledNodes.size() > 0) {
      Node node = getMinimum(unSettledNodes);
      settledNodes.add(node);
      unSettledNodes.remove(node);
      findMinimalDistances(node);
    }
    return this;
  }

  /**
   * @return the shortest path from the source to the target or {@code null} if none.
   */
  public Path to(Node target) {
    LinkedList<Node> path = new LinkedList<Node>();
    Node step = target;
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

  private void findMinimalDistances(Node node) {
    List<Node> adjacentNodes = getNeighbors(node);
    for (Node target: adjacentNodes) {
      if (getShortestDistance(target) > getShortestDistance(node)
              + getDistance(node, target)) {
        distance.put(target, getShortestDistance(node)
                + getDistance(node, target));
        predecessors.put(target, node);
        unSettledNodes.add(target);
      }
    }
  }

  private int getDistance(Node node, Node target) {
    Integer distance
    graph.doWithEdges {Edge edge ->
      if (edge.connects(node, target)) {
        distance = edge.getWeight();
      }
    }
    if (distance){
      return distance;
    }
    throw new RuntimeException("Should not happen");
  }

  private List<Node> getNeighbors(Node node) {
    List<Node> neighbors = new ArrayList<Node>();
    graph.doWithEdges {Edge edge ->
      if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
        neighbors.add(edge.getDestination());
      }
    }
    return neighbors;
  }

  private Node getMinimum(Set<Node> nodes) {
    Node minimum = null;
    for (Node node: nodes) {
      if (minimum == null) {
        minimum = node;
      } else {
        if (getShortestDistance(node) < getShortestDistance(minimum)) {
          minimum = node;
        }
      }
    }
    return minimum;
  }

  private boolean isSettled(Node node) {
    return settledNodes.contains(node);
  }

  private int getShortestDistance(Node destination) {
    Integer distance = this.distance.get(destination);
    distance?:Integer.MAX_VALUE;
  }
}