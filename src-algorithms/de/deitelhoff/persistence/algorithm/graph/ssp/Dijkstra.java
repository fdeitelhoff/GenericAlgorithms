package de.deitelhoff.persistence.algorithm.graph.ssp;

import de.deitelhoff.persistence.algorithm.base.AbstractAlgorithm;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.result.AlgorithmResult;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 10:47
 */
public class Dijkstra<V, E> extends AbstractAlgorithm<V, E>
{
    public Dijkstra(final AlgorithmExecutor<V, E> algorithmExecutor)
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

        final AlgorithmResult<V, E> algorithmResult = algorithmExecutor.start("adjacencylist", vertex);

        final HashMap<V, List<E>> adjList = algorithmResult.getAdjacencyListResult().getAdjacencyList();
        final List<V> vertices = algorithmResult.getBreadthFirstResult().getVertices();

        // Prepare the DijkstraInfos
        final HashMap<V, DijkstraInfo<V, E>> dijkstraInfo = new HashMap<>();

        // All vertices
        PriorityQueue<V> Q = new PriorityQueue<>(vertices.size(), new Comparator<V>()
        {
            @Override
            public int compare(final V vertex1, final V vertex2)
            {
                double distance1 = dijkstraInfo.get(vertex1).distance;
                double distance2 = dijkstraInfo.get(vertex2).distance;

                return Double.compare(distance1, distance2);
            }
        });

        // Set the DijkstraInfos
        for (final V currentVertex : vertices)
        {
            dijkstraInfo.put(currentVertex, new DijkstraInfo<V, E>());
        }

        // The start vertex has the distance 0
        dijkstraInfo.get(startVertex).distance = 0;

        // Add all vertices
        Q.addAll(vertices);

        while (!Q.isEmpty())
        {
            // Vertex with the shortes distance
            final V currentVertex = Q.poll();

            // Iterate through all leaving edges
            for (final E edge : adjList.get(currentVertex))
            {
                // Is this path shorter than the current one
                final double weight = algorithmExecutor.retrieveEdgeWeight(edge);
                final V currentEndVertex = algorithmExecutor.retrieveEndVertex(edge);

                if (dijkstraInfo.get(currentVertex).distance + weight < dijkstraInfo.get(currentEndVertex).distance)
                {
                    // Refresh the vertex
                    dijkstraInfo.get(currentEndVertex).distance = dijkstraInfo.get(currentVertex).distance + weight;
                    dijkstraInfo.get(currentEndVertex).predecessor = currentVertex;
                    dijkstraInfo.get(currentEndVertex).edge = edge;

                    // Renew the queue so it can perform a new comparisons
                    Q.remove(currentEndVertex);
                    Q.add(currentEndVertex);
                }
            }
        }

        final HashMap<V, List<E>> shortestPaths = new HashMap<>();

        for (final V currentVertex : vertices)
        {
            shortestPaths.put(currentVertex, new Vector<E>());
        }

        for (final V currentVertex : vertices)
        {
            V predecessor = currentVertex;
            while (dijkstraInfo.get(predecessor).predecessor != null)
            {
                shortestPaths.get(currentVertex).add(dijkstraInfo.get(predecessor).edge);
                predecessor = dijkstraInfo.get(predecessor).predecessor;
            }
        }

        return new AlgorithmResult<>(new SspResult<>(shortestPaths));
    }

    private class DijkstraInfo<V, E>
    {
        public double distance;
        public V predecessor;
        public E edge;

        public DijkstraInfo()
        {
            this.distance = Integer.MAX_VALUE;
            this.predecessor = null;
            this.edge = null;
        }
    }
}
