package de.vogella.algorithms.dijkstra.test;

import de.vogella.algorithms.dijkstra.model.Edge;
import de.vogella.algorithms.dijkstra.model.Graph;
import de.vogella.algorithms.dijkstra.model.Path;
import de.vogella.algorithms.dijkstra.model.Vertex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static de.vogella.algorithms.dijkstra.engine.DijkstraAlgorithm.FindPathInGraph;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DijkstraAlgorithm_Test {

  private final List<Edge> edges = new ArrayList<Edge>();
  private final Graph graph = new Graph(edges);

  @Test
  public void findsShortestPath() {
    createVertices();
    createEdges();
    Vertex source = graph.getNode(0);
    Vertex target = graph.getNode(10);
    Path resultPath = FindPathInGraph(graph).from(source).to(target);
    Path expectedPath = new Path(source, graph.getNode(2), graph.getNode(7), graph.getNode(9), target);
    assertThat(resultPath, is(expectedPath));
  }

  private void createEdges() {
    addLane(0, 1, 85);
    addLane(0, 2, 217);
    addLane(0, 4, 173);
    addLane(2, 6, 186);
    addLane(2, 7, 103);
    addLane(3, 7, 183);
    addLane(5, 8, 250);
    addLane(8, 9, 84);
    addLane(7, 9, 167);
    addLane(4, 9, 502);
    addLane(9, 10, 40);
    addLane(1, 10, 600);
  }

  private void createVertices() {
    for (int i = 0; i < 11; i++) {
      Vertex location = new Vertex("Node_" + i);
      graph.addNode(location);
    }
  }

  private void addLane(int sourceLocNo, int destLocNo, int duration) {
    String laneId = "Edge_" + edges.size();
    Edge lane = new Edge(laneId, graph.getNode(sourceLocNo), graph.getNode(destLocNo), duration);
    edges.add(lane);
  }
}