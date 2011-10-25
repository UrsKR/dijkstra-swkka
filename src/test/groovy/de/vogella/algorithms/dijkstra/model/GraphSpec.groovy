package de.vogella.algorithms.dijkstra.model;


import spock.lang.Specification

public class GraphSpec extends Specification {

  private final Graph graph = new Graph();

  def "Initial graph has no nodes"() {
    when:
      firstNode();
    then:
      thrown IndexOutOfBoundsException
  }

  def "Initial graph has no edges"() {
    expect:
      graph.getEdges().size() == 0
  }

  def "creates one new node per call"() {
    when:
      createTwoNodes();
    then:
      firstNode() != nodeWithNumber(1)
  }

  def "maintains the order of nodes"() {
    when:
      createTwoNodes();
    then:
      firstNode() == firstNode()
  }

  def "operates on each edge"() {
    given:
      createThreeNodes()
      graph.addEdge(nodeWithNumber(0), nodeWithNumber(1), 15)
      graph.addEdge(nodeWithNumber(1), nodeWithNumber(2), 30)
      int numberOfEdges = 0
    when:
      graph.doWithEdges {numberOfEdges++}
    then:
      numberOfEdges == 2
  }


  private void createThreeNodes() {
    graph.addNode();
    graph.addNode();
    graph.addNode();
  }

  private void createTwoNodes() {
    graph.addNode();
    graph.addNode();
  }

  private Node firstNode() {
    return nodeWithNumber(0);
  }

  private Node nodeWithNumber(int number) {
    return graph.getNode(number);
  }
}