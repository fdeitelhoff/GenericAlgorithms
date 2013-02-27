package de.deitelhoff.persistence.algorithm.graph.mst;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 20:42
 */
public class MstResult<E>
{
    private List<E> minimumSpanningTree;

    public MstResult(List<E> minimumSpanningTree)
    {
        this.minimumSpanningTree = minimumSpanningTree;
    }

    public List<E> getMinimumSpanningTree()
    {
        return minimumSpanningTree;
    }
}
