package de.deitelhoff.persistence.algorithm.graph.mst;

import de.deitelhoff.persistence.algorithm.base.AbstractAlgorithm;
import de.deitelhoff.persistence.algorithm.dataStructure.UnionFind;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.graph.searching.BreadthFirstResult;
import de.deitelhoff.persistence.algorithm.result.AlgorithmResult;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 22.05.12
 * Time: 21:32
 */
public class Kruskal<V, E> extends AbstractAlgorithm<V, E>
{
    public Kruskal(AlgorithmExecutor<V, E> algorithmExecutor)
    {
        super(algorithmExecutor);
    }

    @Override
    public AlgorithmResult<V, E> start(final V vertex, final V startVertex, final V endVertex) throws IllegalGraphException
    {
        // Get all vertices and edges first.
        final BreadthFirstResult<V, E> breadthFirstResult
                = algorithmExecutor.start("breadthfirstnoorientation", vertex).getBreadthFirstResult();
        final List<V> vertices = breadthFirstResult.getVertices();
        final List<E> edges = breadthFirstResult.getEdges();

        if (edges.size() == 0)
        {
            throw new IllegalGraphException("The are no edges in the graph");
        }

        final List<E> minimumSpanningTree = new Vector<>();

        final UnionFind<V> unionFind = new UnionFind<>(vertices);

        // Save edges sorted by a user defined edge weight.
        final PriorityQueue<E> Q = new PriorityQueue<>(edges.size(), new Comparator<E>()
        {
            public int compare(E a, E b)
            {
                double aw = algorithmExecutor.retrieveEdgeWeight(a);
                double bw = algorithmExecutor.retrieveEdgeWeight(b);

                return Double.compare(aw, bw);
            }
        });

        Q.addAll(edges);

        while (!Q.isEmpty())
        {
            final E edge = Q.poll();

            final V startNode = algorithmExecutor.retrieveStartVertex(edge);
            final V endNode = algorithmExecutor.retrieveEndVertex(edge);

            if (unionFind.find(startNode) != unionFind.find(endNode))
            {
                unionFind.union(startNode, endNode);

                minimumSpanningTree.add(edge);
            }
        }

        return new AlgorithmResult<>(new MstResult<>(minimumSpanningTree));
    }
}
