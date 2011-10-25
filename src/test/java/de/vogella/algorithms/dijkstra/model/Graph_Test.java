package de.vogella.algorithms.dijkstra.model;

import org.junit.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class Graph_Test {

  @Test(expected = IndexOutOfBoundsException.class)
  public void hasNoNodesInitially() throws Exception {
    List<Edge> edges = emptyList();
    Graph graph = new Graph(edges);
    graph.getNode(0);
  }

  @Test
  public void createsOneNodePerCall() throws Exception {
    List<Edge> edges = emptyList();
    Graph graph = new Graph(edges);
    graph.addNode();
    graph.addNode();
    assertThat(graph.getNode(0), is(not(graph.getNode(1))));
  }

  @Test
  public void maintainsTheOrderOfNodes() throws Exception {
    List<Edge> edges = emptyList();
    Graph graph = new Graph(edges);
    graph.addNode();
    graph.addNode();
    assertThat(graph.getNode(0), is(graph.getNode(0)));
  }
}