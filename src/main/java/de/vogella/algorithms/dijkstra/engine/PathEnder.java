package de.vogella.algorithms.dijkstra.engine;

import de.vogella.algorithms.dijkstra.model.Path;
import de.vogella.algorithms.dijkstra.model.Vertex;

import java.util.LinkedList;

public interface PathEnder {

  Path to(Vertex target);
}
