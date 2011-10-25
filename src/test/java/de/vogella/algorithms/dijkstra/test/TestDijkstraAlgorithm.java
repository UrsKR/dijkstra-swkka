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

public class TestDijkstraAlgorithm {

  private final List<Vertex> nodes = new ArrayList<Vertex>();
  private final List<Edge> edges = new ArrayList<Edge>();
  private final Graph graph = new Graph(nodes, edges);

  @Test
  public void findsShortestPath() {
    createVertices();
    createEdges();
    DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
    dijkstra.execute(nodes.get(0));
    LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));
    assertNotNull(path);
    assertTrue(path.size() > 0);
    assertThat(path, hasItems(nodes.get(0), nodes.get(2), nodes.get(7), nodes.get(9), nodes.get(10)));
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
    Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
    edges.add(lane);
  }
}