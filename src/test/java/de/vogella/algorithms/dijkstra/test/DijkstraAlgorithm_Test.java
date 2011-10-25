package de.vogella.algorithms.dijkstra.test;

import de.vogella.algorithms.dijkstra.engine.DijkstraAlgorithm;
import de.vogella.algorithms.dijkstra.model.Edge;
import de.vogella.algorithms.dijkstra.model.Graph;
import de.vogella.algorithms.dijkstra.model.Vertex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class DijkstraAlgorithm_Test {

  private final List<Vertex> nodes = new ArrayList<Vertex>();
  private final List<Edge> edges = new ArrayList<Edge>();
  private final Graph graph = new Graph(nodes, edges);

  @Test
  public void findsShortestPath() {
    createVertices();
    createEdges();
    Vertex source = getNode(0);
    Vertex target = getNode(10);
    DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graph);
    algorithm.execute(source);
    LinkedList<Vertex> path = algorithm.getPath(target);
    assertThat(path, hasItems(source, getNode(2), getNode(7), getNode(9), target));
  }

  private void createEdges() {
    addLane("Edge_0", 0, 1, 85);
    addLane("Edge_1", 0, 2, 217);
    addLane("Edge_2", 0, 4, 173);
    addLane("Edge_3", 2, 6, 186);
    addLane("Edge_4", 2, 7, 103);
    addLane("Edge_5", 3, 7, 183);
    addLane("Edge_6", 5, 8, 250);
    addLane("Edge_7", 8, 9, 84);
    addLane("Edge_8", 7, 9, 167);
    addLane("Edge_9", 4, 9, 502);
    addLane("Edge_10", 9, 10, 40);
    addLane("Edge_11", 1, 10, 600);
  }

  private void createVertices() {
    for (int i = 0; i < 11; i++) {
      Vertex location = new Vertex("Node_" + i, "Node_" + i);
      nodes.add(location);
    }
  }

  private void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
    Edge lane = new Edge(laneId, getNode(sourceLocNo), getNode(destLocNo), duration);
    edges.add(lane);
  }

  private Vertex getNode(int number) {
    return nodes.get(number);
  }
}