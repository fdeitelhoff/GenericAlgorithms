package de.deitelhoff.persistence.algorithm.graph.adjacency;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 02.06.12
 * Time: 17:17
 */
public class AdjacencyListResult<V, E>
{
    private final HashMap<V, List<E>> adjacencyList;

    public AdjacencyListResult(HashMap<V, List<E>> adjacencyList)
    {
        this.adjacencyList = adjacencyList;
    }

    public HashMap<V, List<E>> getAdjacencyList()
    {
        return adjacencyList;
    }
}
