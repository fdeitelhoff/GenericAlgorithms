package de.deitelhoff.persistence.algorithm.test.graph.maxFlow;

import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutorFactory;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkEdge;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkVertex;
import de.deitelhoff.persistence.algorithm.graph.data.TestGraphFactory;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.graph.maxFlow.MaxFlowResult;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 02.06.12
 * Time: 23:54
 */
public class MaxFlowFordFulkersonTests
{
    @Test
    public void testGraphMaxFlowTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createTestGraph();
        final List<NetworkVertex> vertices = TestGraphFactory.getVertices();
        final double maxFlowExpected = 5;

        final NetworkVertex startVertex = firstVertex;
        final NetworkVertex endVertex = vertices.get(3);

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final MaxFlowResult maxFlowResult
                = algorithmExecutor.start("maxflow", firstVertex, startVertex, endVertex).getMaxFlowResult();
        final double maxFlow = maxFlowResult.getMaxFlow();

        // Assert
        assertNotNull(maxFlowResult);
        assertEquals(maxFlowExpected, maxFlow);
    }

    @Test(expected = IllegalGraphException.class)
    public void emptyGraphMaxFlowTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createEmptyTestGraph();

        final NetworkVertex startVertex = firstVertex;
        final NetworkVertex endVertex = null;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start("maxflow", firstVertex, startVertex, endVertex).getMaxFlowResult();
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneVertexGraphMaxFlowTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createOneVertexTestGraph();

        final NetworkVertex startVertex = firstVertex;
        final NetworkVertex endVertex = firstVertex;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start("maxflow", firstVertex, startVertex, endVertex).getMaxFlowResult();
    }

    @Test
    public void simpleGraphMaxFlowTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createSimpleTestGraph();
        final List<NetworkVertex> vertices = TestGraphFactory.getVertices();
        final double maxFlowExpected = 10;

        final NetworkVertex startVertex = firstVertex;
        final NetworkVertex endVertex = vertices.get(1);

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final MaxFlowResult maxFlowResult
                = algorithmExecutor.start("maxflow", firstVertex, startVertex, endVertex).getMaxFlowResult();
        final double maxFlow = maxFlowResult.getMaxFlow();

        // Assert
        assertNotNull(maxFlowResult);
        assertEquals(maxFlowExpected, maxFlow);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyStartVertexGraphMaxFlowTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createTestGraph();

        final NetworkVertex startVertex = null;
        final NetworkVertex endVertex = firstVertex;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start("maxflow", firstVertex, startVertex, endVertex).getMaxFlowResult();
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyEndVertexGraphMaxFlowTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createTestGraph();

        final NetworkVertex startVertex = firstVertex;
        final NetworkVertex endVertex = null;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start("maxflow", firstVertex, startVertex, endVertex).getMaxFlowResult();
    }
}
