package de.deitelhoff.persistence.algorithm.graph.maxFlow;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 21:19
 */
public class MaxFlowResult
{
    private final double maxFlow;

    public MaxFlowResult(double maxFlow)
    {
        this.maxFlow = maxFlow;
    }

    public double getMaxFlow()
    {
        return maxFlow;
    }
}
