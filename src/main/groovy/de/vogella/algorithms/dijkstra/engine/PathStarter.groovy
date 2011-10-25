package de.vogella.algorithms.dijkstra.engine;

import de.vogella.algorithms.dijkstra.model.Node;

public interface PathStarter {

  PathEnder from(Node source);
}
