package de.deitelhoff.persistence.algorithm.nullable;

import de.deitelhoff.persistence.algorithm.base.AbstractAlgorithm;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.result.AlgorithmResult;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 18:53
 */
public class NullableAlgorithm<V, E> extends AbstractAlgorithm<V, E>
{
    public NullableAlgorithm(AlgorithmExecutor<V, E> algorithmExecutor)
    {
        super(algorithmExecutor);
    }

    @Override
    public AlgorithmResult<V, E> start(V vertex, V startVertex, V endVertex)
    {
        return new AlgorithmResult<>();
    }
}
