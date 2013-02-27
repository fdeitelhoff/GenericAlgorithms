package de.deitelhoff.persistence.algorithm.graph.searching;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 31.05.12
 * Time: 23:32
 */
public class BreadthFirstResult<V, E>
{
    private final List<V> vertices;
    private final List<E> edges;

    public BreadthFirstResult(List<V> vertices, List<E> edges)
    {
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<V> getVertices()
    {
        return vertices;
    }

    public List<E> getEdges()
    {
        return edges;
    }
}
