package de.vogella.algorithms.dijkstra.engine

import de.vogella.algorithms.dijkstra.model.Node
import de.vogella.algorithms.dijkstra.model.Edge
import de.vogella.algorithms.dijkstra.model.Graph

class ShortestPathCalculator {

  private final Set<Node> settledNodes = []
  private final Set<Node> unSettledNodes = []
  private final Map<Node, Integer> distance = [:]
  Map<Node, Node> predecessors
  Graph graph

  def calculatePathsFrom(Node source) {
    distance.put(source, 0);
    unSettledNodes.add(source);
    while (unSettledNodes.size() > 0) {
      Node node = getMinimum(unSettledNodes);
      settledNodes.add(node);
      unSettledNodes.remove(node);
      findMinimalDistances(node);
    }
  }


  private void findMinimalDistances(Node node) {
    List<Node> adjacentNodes = getNeighbors(node);
    for (Node target: adjacentNodes) {
      if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
        distance.put(target, getShortestDistance(node) + getDistance(node, target));
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