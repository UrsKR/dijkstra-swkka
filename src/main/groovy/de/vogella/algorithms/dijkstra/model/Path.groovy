package de.vogella.algorithms.dijkstra.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class Path {

  private List<Node> nodes;

  public Path() {
    this(new ArrayList<Node>());
  }

  public Path(Node... vertices) {
    this(asList(vertices));
  }

  public Path(List<Node> nodes) {
    this.nodes = nodes;
  }

  @Override
  public boolean equals(Object object) {
    return reflectionEquals(this, object);
  }

  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }
}