package de.vogella.algorithms.dijkstra.engine;

import de.vogella.algorithms.dijkstra.model.Vertex;

import java.util.LinkedList;

public interface PathEnder {

  LinkedList<Vertex> to(Vertex target);
}
