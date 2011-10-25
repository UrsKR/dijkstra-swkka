package de.vogella.algorithms.dijkstra.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class Graph_Test {

  private final Graph graph = new Graph();

  @Test(expected = IndexOutOfBoundsException.class)
  public void hasNoNodesInitially() throws Exception {
    firstNode();
  }

  @Test
  public void hasNoEdgesInitially() throws Exception {
    assertThat(graph.getEdges().size(), is(0));
  }

  @Test
  public void createsOneNodePerCall() throws Exception {
    createTwoNodes();
    assertThat(firstNode(), is(not(nodeWithNumber(1))));
  }

  @Test
  public void maintainsTheOrderOfNodes() throws Exception {
    createTwoNodes();
    assertThat(firstNode(), is(firstNode()));
  }

  private void createTwoNodes() {
    graph.addNode();
    graph.addNode();
  }

  private Vertex firstNode() {
    return nodeWithNumber(0);
  }

  private Vertex nodeWithNumber(int number) {
    return graph.getNode(number);
  }
}