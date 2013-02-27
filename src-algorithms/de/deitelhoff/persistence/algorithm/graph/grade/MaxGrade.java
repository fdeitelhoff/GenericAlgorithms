package de.deitelhoff.persistence.algorithm.graph.grade;

import de.deitelhoff.persistence.algorithm.base.AbstractAlgorithm;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.result.AlgorithmResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 31.05.12
 * Time: 22:54
 */
public class MaxGrade<V, E> extends AbstractAlgorithm<V, E>
{
    public MaxGrade(final AlgorithmExecutor<V, E> algorithmExecutor)
    {
        super(algorithmExecutor);
    }

    @Override
    public AlgorithmResult<V, E> start(final V vertex, final V startVertex, final V endVertex) throws IllegalGraphException
    {
        final AlgorithmResult<V, E> algorithmResult = algorithmExecutor.start("breadthfirstnoorientation", vertex);
        final List<V> vertices = algorithmResult.getBreadthFirstResult().getVertices();

        int maxGrade = 0;

        for (final V currentVertex : vertices)
        {
            final int grade = algorithmExecutor.retrieveEdges(currentVertex).size();

            if (grade > maxGrade)
            {
                maxGrade = grade;
            }
        }

        return new AlgorithmResult<>(algorithmResult.getBreadthFirstResult(), new MaxGradeResult(maxGrade));
    }
}
