package de.deitelhoff.persistence.algorithm.graph.maxFlow;

import de.deitelhoff.persistence.algorithm.base.AbstractAlgorithm;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.result.AlgorithmResult;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 14:00
 */
public class FordFulkerson<V, E> extends AbstractAlgorithm<V, E>
{
    private Map<V, List<ResidualEdge<V>>> adj = new HashMap<>();
    private Map<ResidualEdge<V>, Double> flow = new HashMap<>();

    public FordFulkerson(final AlgorithmExecutor<V, E> algorithmExecutor)
    {
        super(algorithmExecutor);
    }

    @Override
    public AlgorithmResult<V, E> start(final V vertex, final V startVertex, final V endVertex) throws IllegalGraphException
    {
        if (startVertex == null)
        {
            throw new IllegalArgumentException("The start vertex can not be null");
        }

        if (endVertex == null)
        {
            throw new IllegalArgumentException("The end vertex can not be null");
        }

        if (startVertex == endVertex)
        {
            throw new IllegalArgumentException("The start and end vertices could not be the same");
        }

        final AlgorithmResult<V, E> algorithmResult = algorithmExecutor.start("breadthfirst", vertex);

        final List<E> edges = algorithmResult.getBreadthFirstResult().getEdges();

        for (final E edge : edges)
        {
            addResidualEdge(algorithmExecutor.retrieveStartVertex(edge),
                    algorithmExecutor.retrieveEndVertex(edge),
                    algorithmExecutor.retrieveEdgeWeight(edge), 0);
        }

        Set<ResidualEdge<V>> path = findPath(startVertex, endVertex);
        while (path != null)
        {
            double minFlow = Double.MAX_VALUE;
            for (ResidualEdge e : path)
            {
                minFlow = Math.min(minFlow, e.residualCapacity);
            }
            for (ResidualEdge<V> e : path)
            {
                flow.put(e, flow.get(e) + minFlow);
                flow.put(e.reverseEdge, flow.get(e.reverseEdge) - minFlow);
            }
            path = findPath(startVertex, endVertex);
        }

        double maxFlow = 0;
        for (ResidualEdge residualEdge : adj.get(startVertex))
        {
            maxFlow += flow.get(residualEdge);
        }

        return new AlgorithmResult<>(new MaxFlowResult(maxFlow));
    }

    private final List<ResidualEdge<V>> getAdj(final V vertex, final List<ResidualEdge<V>> value)
    {
        if (adj.containsKey(vertex))
        {
            return adj.get(vertex);
        }
        else
        {
            adj.put(vertex, value);
            return value;
        }
    }

    private boolean findPath(final V source, final V sink, final Set<ResidualEdge<V>> path, final Set<V> visited)
    {
        if (visited.contains(source))
        {
            return false;
        }
        visited.add(source);
        if (source == sink)
        {
            return true;
        }
        else
        {
            for (final ResidualEdge<V> residualEdge : adj.get(source))
            {
                residualEdge.residualCapacity = residualEdge.capacity - flow.get(residualEdge);
                if (residualEdge.residualCapacity > 0 && !path.contains(residualEdge))
                {
                    path.add(residualEdge);

                    if (findPath(residualEdge.sink, sink, path, visited))
                    {
                        return true;
                    }

                    path.remove(residualEdge);
                }
            }
        }

        return false;
    }

    private final Set<ResidualEdge<V>> findPath(final V source, final V sink)
    {
        final Set<ResidualEdge<V>> path = new HashSet<>();
        final Set<V> visited = new HashSet<>();
        if (findPath(source, sink, path, visited))
        {
            return path;
        }
        else
        {
            return null;
        }
    }

    private final ResidualEdge<V> addResidualEdge(final V startVertex, final V endVertex, final double w, final double z)
    {
        final ResidualEdge<V> residualEdge = new ResidualEdge<>(startVertex, endVertex, w);
        final ResidualEdge<V> reverseEdge = new ResidualEdge<>(endVertex, startVertex, z);
        residualEdge.reverseEdge = reverseEdge;
        reverseEdge.reverseEdge = residualEdge;

        getAdj(startVertex, new ArrayList<ResidualEdge<V>>()).add(residualEdge);
        getAdj(endVertex, new ArrayList<ResidualEdge<V>>()).add(reverseEdge);

        flow.put(residualEdge, 0.);
        flow.put(reverseEdge, 0.);

        return residualEdge;
    }

    private static class ResidualEdge<V>
    {
        V source;
        V sink;
        double capacity;
        double residualCapacity;
        ResidualEdge<V> reverseEdge;

        public ResidualEdge(final V source, final V sink, final double capacity)
        {
            this.source = source;
            this.sink = sink;
            this.capacity = capacity;
        }
    }
}
