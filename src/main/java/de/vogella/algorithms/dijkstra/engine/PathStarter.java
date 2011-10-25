package de.vogella.algorithms.dijkstra.engine;

import de.vogella.algorithms.dijkstra.model.Vertex;

public interface PathStarter {

  PathEnder from(Vertex source);
}
