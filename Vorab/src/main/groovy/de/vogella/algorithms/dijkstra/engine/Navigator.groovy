package de.vogella.algorithms.dijkstra.engine

import de.vogella.algorithms.dijkstra.model.Path
import de.vogella.algorithms.dijkstra.model.Node

class Navigator {

  private Map<Node, Node> predecessors

  Path findPathTo(Node target) {
    Path path = new Path();
    if (thereIsNoPathFromSourceTo(target)) {
      return path;
    }
    Node step = target;
    path.addNode(step);
    while (weAreNotYetAtTheSource(step)) {
      step = predecessors.get(step);
      path.addNode(step);
    }
    return path
  }

  private def weAreNotYetAtTheSource(Node step) {
    return predecessors.containsKey(step)
  }

  private def thereIsNoPathFromSourceTo(Node step) {
    return !predecessors.get(step)
  }
}
