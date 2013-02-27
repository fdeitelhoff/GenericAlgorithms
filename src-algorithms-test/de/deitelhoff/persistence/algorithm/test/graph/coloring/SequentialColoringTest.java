package de.deitelhoff.persistence.algorithm.test.graph.coloring;

import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutorFactory;
import de.deitelhoff.persistence.algorithm.graph.coloring.ColoringResult;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkEdge;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkVertex;
import de.deitelhoff.persistence.algorithm.graph.data.TestGraphFactory;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 21:45
 */
public class SequentialColoringTest
{
    @Test
    public void testGraphColoringTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createTestGraph();
        final List<NetworkVertex> vertices = TestGraphFactory.getVertices();
        final int vertexCount = TestGraphFactory.getVertices().size();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final ColoringResult<NetworkVertex> coloringResult = algorithmExecutor.start("sequentialcoloring", firstVertex).getColoringResult();
        final HashMap<NetworkVertex, Integer> vertexColoring = coloringResult.getVerticesColoring();

        // Assert
        assertNotNull(coloringResult);
        assertEquals(vertexColoring.size(), vertexCount);

        assertEquals((int) vertexColoring.get(vertices.get(0)), 1);
        assertEquals((int) vertexColoring.get(vertices.get(1)), 2);
        assertEquals((int) vertexColoring.get(vertices.get(2)), 1);
        assertEquals((int) vertexColoring.get(vertices.get(3)), 3);
        assertEquals((int) vertexColoring.get(vertices.get(4)), 3);
        assertEquals((int) vertexColoring.get(vertices.get(5)), 3);
    }

    @Test(expected = IllegalGraphException.class)
    public void emptyGraphColoringTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createEmptyTestGraph();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start("sequentialcoloring", firstVertex).getColoringResult();
    }

    @Test
    public void oneVertexGraphColoringTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createOneVertexTestGraph();
        final List<NetworkVertex> vertices = TestGraphFactory.getVertices();
        final int vertexCount = TestGraphFactory.getVertices().size();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final ColoringResult<NetworkVertex> coloringResult = algorithmExecutor.start("sequentialcoloring", firstVertex).getColoringResult();
        final HashMap<NetworkVertex, Integer> vertexColoring = coloringResult.getVerticesColoring();

        // Assert
        assertNotNull(coloringResult);
        assertEquals(vertexColoring.size(), vertexCount);

        assertEquals((int) vertexColoring.get(vertices.get(0)), 1);
    }

    @Test
    public void simpleGraphColoringTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createSimpleTestGraph();
        final List<NetworkVertex> vertices = TestGraphFactory.getVertices();
        final int vertexCount = TestGraphFactory.getVertices().size();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final ColoringResult<NetworkVertex> coloringResult = algorithmExecutor.start("sequentialcoloring", firstVertex).getColoringResult();
        final HashMap<NetworkVertex, Integer> vertexColoring = coloringResult.getVerticesColoring();

        // Assert
        assertNotNull(coloringResult);
        assertEquals(vertexColoring.size(), vertexCount);

        assertEquals((int) vertexColoring.get(vertices.get(0)), 1);
        assertEquals((int) vertexColoring.get(vertices.get(1)), 2);
    }

    @Test
    public void secondVertexColoringTest() throws IllegalGraphException
    {
        // Arrange
        TestGraphFactory.createSimpleTestGraph();
        final List<NetworkVertex> vertices = TestGraphFactory.getVertices();
        final NetworkVertex secondVertex = vertices.get(1);
        final int vertexCount = TestGraphFactory.getVertices().size();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final ColoringResult<NetworkVertex> coloringResult
                = algorithmExecutor.start("sequentialcoloring", secondVertex).getColoringResult();
        final HashMap<NetworkVertex, Integer> vertexColoring
                = coloringResult.getVerticesColoring();

        // Assert
        assertNotNull(coloringResult);
        assertEquals(vertexColoring.size(), vertexCount);

        assertEquals((int) vertexColoring.get(vertices.get(0)), 2);
        assertEquals((int) vertexColoring.get(vertices.get(1)), 1);
    }
}
