package de.deitelhoff.persistence.algorithm.executor;

import de.deitelhoff.persistence.algorithm.base.AbstractAlgorithm;
import de.deitelhoff.persistence.algorithm.graph.adjacency.AdjacencyList;
import de.deitelhoff.persistence.algorithm.graph.coloring.SequentialColoring;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.graph.grade.MaxGrade;
import de.deitelhoff.persistence.algorithm.graph.maxFlow.FordFulkerson;
import de.deitelhoff.persistence.algorithm.graph.mst.Kruskal;
import de.deitelhoff.persistence.algorithm.graph.searching.BreadthFirst;
import de.deitelhoff.persistence.algorithm.graph.searching.BreadthFirstNoOrientation;
import de.deitelhoff.persistence.algorithm.graph.ssp.Dijkstra;
import de.deitelhoff.persistence.algorithm.nullable.NullableAlgorithm;
import de.deitelhoff.persistence.algorithm.registry.AlgorithmRegistry;
import de.deitelhoff.persistence.algorithm.result.AlgorithmResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 15:06
 */
public abstract class AlgorithmExecutor<V, E>
{
    private AlgorithmRegistry<AbstractAlgorithm<V, E>> registry;
    private NullableAlgorithm<V, E> nullableAlgorithm;

    public AlgorithmExecutor()
    {
        registry = new AlgorithmRegistry<>();
        nullableAlgorithm = new NullableAlgorithm<>(this);

        addAlgorithms();
    }

    private void addAlgorithms()
    {
        Kruskal<V, E> kruskal = new Kruskal<>(this);
        Dijkstra<V, E> dijkstra = new Dijkstra<>(this);
        FordFulkerson<V, E> fordFulkerson = new FordFulkerson<>(this);
        SequentialColoring<V, E> sequentialColoring
                = new SequentialColoring<>(this);

        BreadthFirst<V, E> breadthFirst = new BreadthFirst<>(this);
        BreadthFirstNoOrientation<V, E> breadthFirstNoOrientation = new BreadthFirstNoOrientation<>(this);
        MaxGrade<V, E> maxGrade = new MaxGrade<>(this);
        AdjacencyList<V, E> adjacencyList = new AdjacencyList<>(this);

        registry.addAlgorithm("breadthfirst", breadthFirst);
        registry.addAlgorithm("breadthfirstnoorientation", breadthFirstNoOrientation);
        registry.addAlgorithm("maxgrade", maxGrade);
        registry.addAlgorithm("adjacencylist", adjacencyList);

        registry.addAlgorithm("mst", kruskal);
        registry.addAlgorithm("ssp", dijkstra);
        registry.addAlgorithm("maxflow", fordFulkerson);
        registry.addAlgorithm("sequentialcoloring", sequentialColoring);
    }

    public AlgorithmResult<V, E> start(String algorithm, V vertex, V startVertex, V endVertex) throws IllegalGraphException
    {
        if (algorithm == null)
        {
            throw new IllegalArgumentException("The algorithm name can not be null");
        }

        if (vertex == null)
        {
            throw new IllegalGraphException("The graph was null");
        }

        algorithm = algorithm.trim().toLowerCase();

        if (!registry.algorithmExists(algorithm))
        {
            return nullableAlgorithm.start(vertex, startVertex, endVertex);
        }

        return registry.getAlgorithm(algorithm).start(vertex, startVertex, endVertex);
    }

    public AlgorithmResult<V, E> start(String algorithm, V vertex) throws IllegalGraphException
    {
        return start(algorithm, vertex, null, null);
    }

    public AlgorithmResult<V, E> start(String algorithm, V vertex, V startVertex) throws IllegalGraphException
    {
        return start(algorithm, vertex, startVertex, null);
    }

    public abstract V retrieveStartVertex(E edge);

    public abstract V retrieveEndVertex(E edge);

    public abstract List<E> retrieveEdges(V vertex);

    public abstract double retrieveEdgeWeight(E edge);
}
