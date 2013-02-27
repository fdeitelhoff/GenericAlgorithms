package de.deitelhoff.persistence.algorithm.graph.adjacency;

import de.deitelhoff.persistence.algorithm.base.AbstractAlgorithm;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.result.AlgorithmResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 02.06.12
 * Time: 17:17
 */
public class AdjacencyList<V, E> extends AbstractAlgorithm<V, E>
{
    public AdjacencyList(final AlgorithmExecutor<V, E> algorithmExecutor)
    {
        super(algorithmExecutor);
    }

    @Override
    public AlgorithmResult<V, E> start(final V vertex, final V startVertex, final V endVertex) throws IllegalGraphException
    {
        final AlgorithmResult<V, E> algorithmResult = algorithmExecutor.start("breadthfirst", vertex);

        final List<V> vertices = algorithmResult.getBreadthFirstResult().getVertices();
        final List<E> edges = algorithmResult.getBreadthFirstResult().getEdges();

        final HashMap<V, List<E>> adjacencyList = new HashMap<>(vertices.size());

        for (final V currentVertex : vertices)
        {
            adjacencyList.put(currentVertex, new ArrayList<E>());
        }

        for (final E edge : edges)
        {
            adjacencyList.get(algorithmExecutor.retrieveStartVertex(edge)).add(edge);
        }

        return new AlgorithmResult<>(new AdjacencyListResult<>(adjacencyList),
                algorithmResult.getBreadthFirstResult());
    }
}
