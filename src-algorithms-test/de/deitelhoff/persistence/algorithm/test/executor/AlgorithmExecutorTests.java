package de.deitelhoff.persistence.algorithm.test.executor;

import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutorFactory;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkEdge;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkVertex;
import de.deitelhoff.persistence.algorithm.graph.data.TestGraphFactory;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.result.AlgorithmResult;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 03.06.12
 * Time: 00:53
 */
public class AlgorithmExecutorTests
{
    @Test
    public void nullableAlgorithmExecutorTest() throws IllegalGraphException
    {
        // Arrange
        NetworkVertex firstVertex = TestGraphFactory.createSimpleTestGraph();
        AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        AlgorithmResult<NetworkVertex, NetworkEdge> algorithmResult = algorithmExecutor.start ("", firstVertex);

        // Assert
        assertNotNull(algorithmResult);
        assertNull(algorithmResult.getBreadthFirstResult());
        assertNull(algorithmResult.getAdjacencyListResult());
        assertNull(algorithmResult.getMaxFlowResult());
        assertNull(algorithmResult.getMaxGradeResult());
        assertNull(algorithmResult.getSspResult());
        assertNull(algorithmResult.getColoringResult());
        assertNull(algorithmResult.getMstResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullAlgorithmParameterExecutorTest() throws IllegalGraphException
    {
        // Arrange
        AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start (null, null);
    }
}
