package de.deitelhoff.persistence.algorithm.graph.ssp;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 21:11
 */
public class SspResult<V, E>
{
    private HashMap<V, List<E>> shortestPaths;

    public SspResult(HashMap<V, List<E>> shortestPaths)
    {
        this.shortestPaths = shortestPaths;
    }

    public HashMap<V, List<E>> getShortestPaths()
    {
        return shortestPaths;
    }
}
