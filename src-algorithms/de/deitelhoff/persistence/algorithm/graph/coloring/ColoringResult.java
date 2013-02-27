package de.deitelhoff.persistence.algorithm.graph.coloring;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 21:34
 */
public class ColoringResult<V>
{
    private HashMap<V, Integer> verticesColoring;

    public ColoringResult(HashMap<V, Integer> verticesColoring)
    {
        this.verticesColoring = verticesColoring;
    }

    public HashMap<V, Integer> getVerticesColoring()
    {
        return verticesColoring;
    }
}
