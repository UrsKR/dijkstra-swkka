package de.vogella.algorithms.dijkstra.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class Path_Test {

  @Test
  public void emptyPathsEqual() throws Exception {
    assertThat(new Path(), is(new Path()));
  }

  @Test
  public void identicalPathsEqual() throws Exception {
    Path path = new Path(createVertex("1"));
    assertThat(path, is(path));
  }

  @Test
  public void pathsWithDifferentElementsDoNotEqual() throws Exception {
    Path aPath = new Path(createVertex("1"));
    Path aDifferentPath = new Path(createVertex("2"));
    assertThat(aPath, is(not(aDifferentPath)));
  }

  @Test
  public void differentPathsWithSameElementsEqual() throws Exception {
    Path aPath = new Path(createVertex("1"));
    Path anotherPath = new Path(createVertex("1"));
    assertThat(aPath, is(anotherPath));
  }

  @Test
  public void pathsWithManyIdenticalElementsEqual() throws Exception {
    Path aPath = new Path(createVertex("1"), createVertex("2"), createVertex("3"));
    Path anotherPath = new Path(createVertex("1"), createVertex("2"), createVertex("3"));
    assertThat(aPath, is(anotherPath));
  }

  @Test
  public void equalPathsHaveIdenticalHashCodes() throws Exception {
    Path aPath = new Path(createVertex("1"), createVertex("2"), createVertex("3"));
    Path anotherPath = new Path(createVertex("1"), createVertex("2"), createVertex("3"));
    assertThat(aPath.hashCode(), is(anotherPath.hashCode()));
  }

  private Vertex createVertex(String id) {
    return new Vertex(id);
  }
}
