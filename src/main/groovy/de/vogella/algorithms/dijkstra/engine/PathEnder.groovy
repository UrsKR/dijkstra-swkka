package de.vogella.algorithms.dijkstra.engine;

import de.vogella.algorithms.dijkstra.model.Path;
import de.vogella.algorithms.dijkstra.model.Node;

public interface PathEnder {

  Path to(Node target);
}
