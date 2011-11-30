package de.vogella.algorithms.dijkstra.engine;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.vogella.algorithms.dijkstra.model.Edge;
import de.vogella.algorithms.dijkstra.model.Graph;
import de.vogella.algorithms.dijkstra.model.Node;

import static java.lang.Integer.MAX_VALUE;

public class DijkstraAlgorithm {

    private Set<Node> settledNodes;
    private Set<Node> unSettledNodes;
    private Map<Node, Node> predecessors;
    private Map<Node, Integer> distance;
    private final Graph graph;

    public DijkstraAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public void execute(Node source) {
        settledNodes = new HashSet<Node>();
        unSettledNodes = new HashSet<Node>();
        distance = new HashMap<Node, Integer>();
        predecessors = new HashMap<Node, Node>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            Node node = getNodeWithMinimalDistanceToSourceFromUnsettledNodes();
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Node node) {
        List<Node> adjacentNodes = getNeighbors(node);
        for (Node target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    private int getDistance(Node source, Node target) {
        for (Edge edge : getEdges()) {
            if (edge.connects(source, target)) {
                return edge.getWeight();
            }
        }
        return MAX_VALUE;
    }

    private List<Node> getNeighbors(Node node) {
        List<Node> neighbors = node.getNeighbours(getEdges());
        neighbors.removeAll(settledNodes);
        return neighbors;
    }

    private Node getNodeWithMinimalDistanceToSourceFromUnsettledNodes() {
        Node minimum = null;
        for (Node node : unSettledNodes) {
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

    private int getShortestDistance(Node destination) {
        Integer distanceToDestination = distance.get(destination);
        if (distanceToDestination == null) {
            return MAX_VALUE;
        } else {
            return distanceToDestination;
        }
    }

    /*
      * This method returns the path from the source to the selected target and
      * NULL if no path exists
      */
    public LinkedList<Node> getPath(Node target) {
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
        return path;
    }

    public List<Edge> getEdges() {
        return graph.getEdges();
    }
}