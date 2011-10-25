package de.vogella.algorithms.dijkstra.engine;


import de.vogella.algorithms.dijkstra.model.Edge
import de.vogella.algorithms.dijkstra.model.Graph
import de.vogella.algorithms.dijkstra.model.Node
import de.vogella.algorithms.dijkstra.model.Path

public class DijkstraAlgorithm implements PathEnder, PathStarter {

  public static PathStarter FindPathInGraph(Graph graph) {
    return new DijkstraAlgorithm(graph);
  }

  private final Set<Node> settledNodes = []
  private final Set<Node> unSettledNodes = []
  private final Map<Node, Node> predecessors= [:]
  private final Map<Node, Integer> distance= [:]
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
   * @return the shortest path from the source to the target or an empty path if none.
   */
  public Path to(Node target) {
    Path path = new Path();
    if (thereIsNoPathFrom(target)) {
      return path;
    }
    Node step = target;
    path.addNode(step);
    while (predecessors.get(step)) {
      step = predecessors.get(step);
      path.addNode(step);
    }
    return path
  }

  private def thereIsNoPathFrom(Node step) {
    return !predecessors.get(step)
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
      if (edge.startsAt(node) && !isSettled(edge.getDestination())) {
        neighbors.add(edge.getDestination());
      }
    }
    return neighbors;
  }

  private boolean isSettled(Node node) {
    return settledNodes.contains(node);
  }

  private Node getMinimum(Set<Node> nodes) {
    Node nearestNeighbourCandidate
    for (Node challenger: nodes) {
      nearestNeighbourCandidate = evaluateNewCandidateForNearestNeighbour(nearestNeighbourCandidate, challenger)
    }
    return nearestNeighbourCandidate
  }

  private def evaluateNewCandidateForNearestNeighbour(Node champion, Node challenger) {
    def thereIsNoChampion= !champion
    def theChallengerIsCloser = getShortestDistance(challenger) < getShortestDistance(champion)
    if (thereIsNoChampion || theChallengerIsCloser) {
      return challenger;
    }
    return champion
  }

  private int getShortestDistance(Node destination) {
    Integer distance = this.distance.get(destination);
    distance?:Integer.MAX_VALUE;
  }
}