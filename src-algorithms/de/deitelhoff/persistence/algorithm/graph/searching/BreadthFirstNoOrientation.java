package de.deitelhoff.persistence.algorithm.graph.searching;

import de.deitelhoff.persistence.algorithm.base.AbstractAlgorithm;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.result.AlgorithmResult;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 31.05.12
 * Time: 23:16
 */
public class BreadthFirstNoOrientation<V, E> extends AbstractAlgorithm<V, E>
{
    public BreadthFirstNoOrientation(AlgorithmExecutor<V, E> algorithmExecutor)
    {
        super(algorithmExecutor);
    }

    @Override
    public AlgorithmResult<V, E> start(V vertex, V startVertex, V endVertex) throws IllegalGraphException
    {
        final Queue<V> v = new LinkedList<>();
        v.add(vertex);
        final Set<V> visited = new HashSet<>();

        final List<V> vertices = new ArrayList<>();
        final List<E> edges = new ArrayList<>();

        while (!v.isEmpty())
        {
            final V currentVertex = v.poll();

            if (!vertices.contains(currentVertex))
            {
                vertices.add(currentVertex);
            }

            for (final E edge : algorithmExecutor.retrieveEdges(currentVertex))
            {
                if (!edges.contains(edge))
                {
                    edges.add(edge);
                }

                final V currentEndVertex = algorithmExecutor.retrieveEndVertex(edge);

                if (!visited.contains(currentEndVertex))
                {
                    v.add(currentEndVertex);
                    visited.add(currentEndVertex);
                }

                final V currentStartVertex = algorithmExecutor.retrieveStartVertex(edge);

                if (!visited.contains(currentStartVertex))
                {
                    v.add(currentStartVertex);
                    visited.add(currentStartVertex);
                }
            }
        }

        return new AlgorithmResult<>(new BreadthFirstResult<>(vertices, edges));
    }
}
