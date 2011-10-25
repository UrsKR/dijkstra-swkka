package de.vogella.algorithms.dijkstra.engine;

import de.vogella.algorithms.dijkstra.model.Vertex;

import java.util.LinkedList;

public interface PathFinder {

  LinkedList<Vertex> getPath(Vertex target);
}
