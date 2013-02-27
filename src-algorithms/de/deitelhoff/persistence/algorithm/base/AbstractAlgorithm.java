package de.deitelhoff.persistence.algorithm.base;

import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.result.AlgorithmResult;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 22.05.12
 * Time: 21:52
 */
public abstract class AbstractAlgorithm<V, E>
{
    protected AlgorithmExecutor<V, E> algorithmExecutor;

    public AbstractAlgorithm(final AlgorithmExecutor<V, E> algorithmExecutor)
    {
        this.algorithmExecutor = algorithmExecutor;
    }

    public abstract AlgorithmResult<V, E> start(final V vertex,
                                                final V startVertex,
                                                final V endVertex)
            throws IllegalGraphException;
}
