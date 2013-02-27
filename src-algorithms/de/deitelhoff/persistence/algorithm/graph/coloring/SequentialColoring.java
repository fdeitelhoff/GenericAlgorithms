package de.deitelhoff.persistence.algorithm.graph.coloring;

import de.deitelhoff.persistence.algorithm.base.AbstractAlgorithm;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.result.AlgorithmResult;

import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 16:57
 */
public class SequentialColoring<V, E> extends AbstractAlgorithm<V, E>
{
    private HashMap<V, Integer> verticesColoring;
    private int maxGrade = 0;

    public SequentialColoring(final AlgorithmExecutor<V, E> algorithmExecutor)
    {
        super(algorithmExecutor);
    }

    @Override
    public AlgorithmResult<V, E> start(final V vertex, final V startVertex, final V endVertex) throws IllegalGraphException
    {
        verticesColoring = new HashMap<>();

        final AlgorithmResult<V, E> algorithmResult = algorithmExecutor.start("maxgrade", vertex);

        maxGrade = algorithmResult.getMaxGradeResult().getMaxGrade();
        final List<V> vertices = algorithmResult.getBreadthFirstResult().getVertices();

        int index = 1;

        verticesColoring.put(vertices.get(0), index);

        for (int i = 1; i < vertices.size(); i++)
        {
            index = getNextIndex(vertices.get(i));

            verticesColoring.put(vertices.get(i), index);
        }

        return new AlgorithmResult<>(new ColoringResult<>(verticesColoring));
    }

    private final int getNextIndex(final V vertex)
    {
        final List<E> edges = algorithmExecutor.retrieveEdges(vertex);
        final SortedSet<Integer> indices = new TreeSet<>();

        for (int i = 1; i < maxGrade + 2; i++)
        {
            indices.add(i);
        }

        for (final E edge : edges)
        {
            final V startVertex = algorithmExecutor.retrieveStartVertex(edge);
            final V endVertex = algorithmExecutor.retrieveEndVertex(edge);
            final V currentVertex = startVertex.equals(vertex) ? endVertex : startVertex;

            int currentIndex = 0;

            if (verticesColoring.containsKey(currentVertex))
            {
                currentIndex = verticesColoring.get(currentVertex);
            }

            if (currentIndex >= 1)
            {
                indices.remove(currentIndex);
            }
        }

        return indices.first();
    }
}
