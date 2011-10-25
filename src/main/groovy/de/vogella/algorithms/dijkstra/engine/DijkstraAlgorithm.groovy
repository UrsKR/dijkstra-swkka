package de.vogella.algorithms.dijkstra.engine;


import de.vogella.algorithms.dijkstra.model.Edge
import de.vogella.algorithms.dijkstra.model.Graph
import de.vogella.algorithms.dijkstra.model.Node
import de.vogella.algorithms.dijkstra.model.Path

public class DijkstraAlgorithm implements PathEnder, PathStarter {

  public static PathStarter FindPathInGraph(Graph graph) {
    return new DijkstraAlgorithm(graph);
  }

  private final Map<Node, Node> predecessors= [:]
  private final ShortestPathCalculator calculator


  private DijkstraAlgorithm(Graph graph) {
    this.calculator =  new ShortestPathCalculator(graph: graph, predecessors:predecessors)
  }

  public PathEnder from(Node source) {
    calculator.calculatePathsFrom(source)
    return this;
  }

  public Path to(Node target) {
    new Navigator(predecessors: predecessors).findPathTo(target);
  }
}