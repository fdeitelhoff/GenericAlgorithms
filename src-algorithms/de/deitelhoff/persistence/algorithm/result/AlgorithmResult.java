package de.deitelhoff.persistence.algorithm.result;

import de.deitelhoff.persistence.algorithm.graph.adjacency.AdjacencyListResult;
import de.deitelhoff.persistence.algorithm.graph.coloring.ColoringResult;
import de.deitelhoff.persistence.algorithm.graph.grade.MaxGradeResult;
import de.deitelhoff.persistence.algorithm.graph.maxFlow.MaxFlowResult;
import de.deitelhoff.persistence.algorithm.graph.mst.MstResult;
import de.deitelhoff.persistence.algorithm.graph.searching.BreadthFirstResult;
import de.deitelhoff.persistence.algorithm.graph.ssp.SspResult;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 20:37
 */
public class AlgorithmResult<V, E>
{
    private MstResult<E> mstResult;
    private SspResult<V, E> sspResult;
    private MaxFlowResult maxFlowResult;
    private ColoringResult<V> coloringResult;

    private BreadthFirstResult<V, E> breadthFirstResult;
    private AdjacencyListResult<V, E> adjacencyListResult;
    private MaxGradeResult maxGradeResult;

    public AlgorithmResult()
    {
        // Empty result for the NullableAlgorithm.
    }

    public AlgorithmResult(MstResult<E> mstResult)
    {
        this.mstResult = mstResult;
    }

    public AlgorithmResult(SspResult<V, E> sspResult)
    {
        this.sspResult = sspResult;
    }

    public AlgorithmResult(MaxFlowResult maxFlowResult)
    {
        this.maxFlowResult = maxFlowResult;
    }

    public AlgorithmResult(ColoringResult<V> coloringResult)
    {
        this.coloringResult = coloringResult;
    }

    public AlgorithmResult(BreadthFirstResult<V, E> breadthFirstResult)
    {
        this.breadthFirstResult = breadthFirstResult;
    }

    public AlgorithmResult(AdjacencyListResult<V, E> adjacencyListResult, BreadthFirstResult<V, E> breadthFirstResult)
    {
        this(breadthFirstResult);

        this.adjacencyListResult = adjacencyListResult;
    }

    public AlgorithmResult(BreadthFirstResult<V, E> breadthFirstResult, MaxGradeResult maxGradeResult)
    {
        this(breadthFirstResult);

        this.maxGradeResult = maxGradeResult;
    }

    public MstResult<E> getMstResult()
    {
        return mstResult;
    }

    public SspResult<V, E> getSspResult()
    {
        return sspResult;
    }

    public MaxFlowResult getMaxFlowResult()
    {
        return maxFlowResult;
    }

    public ColoringResult<V> getColoringResult()
    {
        return coloringResult;
    }

    public BreadthFirstResult<V, E> getBreadthFirstResult()
    {
        return breadthFirstResult;
    }

    public AdjacencyListResult<V, E> getAdjacencyListResult()
    {
        return adjacencyListResult;
    }

    public MaxGradeResult getMaxGradeResult()
    {
        return maxGradeResult;
    }
}
