package de.vogella.algorithms.dijkstra.engine;

import java.util.*;

import de.vogella.algorithms.dijkstra.model.Edge;
import de.vogella.algorithms.dijkstra.model.Graph;
import de.vogella.algorithms.dijkstra.model.Node;

import static java.lang.Integer.MAX_VALUE;

public class DijkstraAlgorithm {

    public static final Node Minimum_Unknown = null;
    private Set<Node> settledNodes;
    private Map<Node, Node> predecessors;
    private Map<Node, Integer> distanceByNode;
    private final Graph graph;

    public DijkstraAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public void execute(Node source) {
        settledNodes = new HashSet<Node>();
        distanceByNode = new HashMap<Node, Integer>();
        predecessors = new HashMap<Node, Node>();
        distanceByNode.put(source, 0);
        while (!getUnsettledNodes().isEmpty()) {
            Node node = getNodeWithMinimalDistanceToSourceFromUnsettledNodes();
            settledNodes.add(node);
            findMinimalDistancesFromNodeToNeighbors(node);
        }
    }

    private void findMinimalDistancesFromNodeToNeighbors(Node node) {
        for (Node target : getNeighbors(node)) {
            int distanceToTargetViaNode = getShortestDistance(node) + getDistance(node, target);
            if (getShortestDistance(target) > distanceToTargetViaNode) {
                distanceByNode.put(target, distanceToTargetViaNode);
                predecessors.put(target, node);
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
        for (Node node : getUnsettledNodes()) {
            if (getShortestDistance(node) < getShortestDistance(minimum)) {
                minimum = node;
            }
        }
        return minimum;
    }

    private int getShortestDistance(Node destination) {
        return distanceByNode.containsKey(destination) ? distanceByNode.get(destination) : MAX_VALUE;
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

    private List<Edge> getEdges() {
        return graph.getEdges();
    }

    private Set<Node> getUnsettledNodes() {
        Set<Node> nodes = new HashSet<Node>(distanceByNode.keySet());
        nodes.removeAll(settledNodes);
        return nodes;
    }
}