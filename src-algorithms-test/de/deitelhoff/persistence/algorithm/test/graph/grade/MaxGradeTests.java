package de.deitelhoff.persistence.algorithm.test.graph.grade;

import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutorFactory;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkEdge;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkVertex;
import de.deitelhoff.persistence.algorithm.graph.data.TestGraphFactory;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.graph.grade.MaxGradeResult;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 02.06.12
 * Time: 22:14
 */
public class MaxGradeTests
{
    @Test
    public void testGraphMaxGradeTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createTestGraph();
        final int maxGradeExpected = 5;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final MaxGradeResult maxGradeResult
                = algorithmExecutor.start("maxgrade", firstVertex).getMaxGradeResult();
        final int maxGrade = maxGradeResult.getMaxGrade();

        // Assert
        assertNotNull(maxGradeResult);
        assertEquals(maxGradeExpected, maxGrade);
    }

    @Test(expected = IllegalGraphException.class)
    public void emptyGraphMaxGradeTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createEmptyTestGraph();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start("maxgrade", firstVertex).getMaxGradeResult();
    }

    @Test
    public void oneVertexMaxGradeTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createOneVertexTestGraph();
        final int maxGradeExpected = 0;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final MaxGradeResult maxGradeResult = algorithmExecutor.start("maxgrade", firstVertex).getMaxGradeResult();
        final int maxGrade = maxGradeResult.getMaxGrade();

        // Assert
        assertNotNull(maxGradeResult);
        assertEquals(maxGradeExpected, maxGrade);
    }

    @Test
    public void simpleGraphMaxGradeTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createSimpleTestGraph();
        final int maxGradeExpected = 1;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final MaxGradeResult maxGradeResult = algorithmExecutor.start("maxgrade", firstVertex).getMaxGradeResult();
        final int maxGrade = maxGradeResult.getMaxGrade();

        // Assert
        assertNotNull(maxGradeResult);
        assertEquals(maxGradeExpected, maxGrade);
    }
}
