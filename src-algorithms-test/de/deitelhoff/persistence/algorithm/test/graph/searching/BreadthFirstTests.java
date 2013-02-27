package de.deitelhoff.persistence.algorithm.test.graph.searching;

import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutorFactory;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkEdge;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkVertex;
import de.deitelhoff.persistence.algorithm.graph.data.TestGraphFactory;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.graph.searching.BreadthFirstResult;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 02.06.12
 * Time: 22:33
 */
public class BreadthFirstTests
{
    @Test
    public void testGraphBreadthFirstTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createTestGraph();
        final int vertexCount = 6;
        final int edgeCount = 10;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final BreadthFirstResult<NetworkVertex, NetworkEdge> breadthFirstResult
                = algorithmExecutor.start("breadthfirst", firstVertex).getBreadthFirstResult();
        final List<NetworkVertex> vertices = breadthFirstResult.getVertices();
        final List<NetworkEdge> edges = breadthFirstResult.getEdges();

        // Assert
        assertTrue(breadthFirstResult != null);
        assertEquals(vertices.size(), vertexCount);
        assertEquals(edges.size(), edgeCount);
    }

    @Test(expected = IllegalGraphException.class)
    public void emptyGraphBreadthFirstTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createEmptyTestGraph();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start("breadthfirst", firstVertex).getBreadthFirstResult();
    }

    @Test
    public void oneVertexGraphBreadthFirstTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createOneVertexTestGraph();
        final int vertexCount = 1;
        final int edgeCount = 0;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final BreadthFirstResult<NetworkVertex, NetworkEdge> breadthFirstResult
                = algorithmExecutor.start("breadthfirst", firstVertex).getBreadthFirstResult();
        final List<NetworkVertex> vertices = breadthFirstResult.getVertices();
        final List<NetworkEdge> edges = breadthFirstResult.getEdges();

        // Assert
        assertTrue(breadthFirstResult != null);
        assertEquals(vertices.size(), vertexCount);
        assertEquals(edges.size(), edgeCount);

        // Node 1
        assertTrue(vertices.contains(TestGraphFactory.getVertices().get(0)));
    }

    @Test
    public void simpleGraphBreadthFirstTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createSimpleTestGraph();
        final int vertexCount = 2;
        final int edgeCount = 1;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final BreadthFirstResult<NetworkVertex, NetworkEdge> breadthFirstResult
                = algorithmExecutor.start("breadthfirst", firstVertex).getBreadthFirstResult();
        final List<NetworkVertex> vertices = breadthFirstResult.getVertices();
        final List<NetworkEdge> edges = breadthFirstResult.getEdges();

        // Assert
        assertTrue(breadthFirstResult != null);
        assertEquals(vertices.size(), vertexCount);
        assertEquals(edges.size(), edgeCount);

        // Node 1, 2
        assertTrue(vertices.contains(TestGraphFactory.getVertices().get(0)));
        assertTrue(vertices.contains(TestGraphFactory.getVertices().get(1)));

        // Edges a
        assertTrue(edges.contains(TestGraphFactory.getEdges().get(0)));
    }

    @Test
    public void secondVertexGraphBreadthFirstTest() throws IllegalGraphException
    {
        // Arrange
        TestGraphFactory.createSimpleTestGraph();
        final NetworkVertex secondVertex = TestGraphFactory.getVertices().get(1);
        final int vertexCount = 1;
        final int edgeCount = 1;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final BreadthFirstResult<NetworkVertex, NetworkEdge> breadthFirstResult
                = algorithmExecutor.start("breadthfirst", secondVertex).getBreadthFirstResult();
        final List<NetworkVertex> vertices = breadthFirstResult.getVertices();
        final List<NetworkEdge> edges = breadthFirstResult.getEdges();

        // Assert
        assertTrue(breadthFirstResult != null);
        assertEquals(vertices.size(), vertexCount);
        assertEquals(edges.size(), edgeCount);

        // Node 2
        assertTrue(vertices.contains(TestGraphFactory.getVertices().get(1)));

        // Edges a
        assertTrue(edges.contains(TestGraphFactory.getEdges().get(0)));
    }

    @Test
    public void sixthVertexGraphBreadthFirstTest() throws IllegalGraphException
    {
        // Arrange
        TestGraphFactory.createTestGraph();
        final NetworkVertex sixthVertex = TestGraphFactory.getVertices().get(5);
        final int vertexCount = 3;
        final int edgeCount = 7;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final BreadthFirstResult<NetworkVertex, NetworkEdge> breadthFirstResult
                = algorithmExecutor.start("breadthfirst", sixthVertex).getBreadthFirstResult();
        final List<NetworkVertex> vertices = breadthFirstResult.getVertices();
        final List<NetworkEdge> edges = breadthFirstResult.getEdges();

        // Assert
        assertTrue(breadthFirstResult != null);
        assertEquals(vertices.size(), vertexCount);
        assertEquals(edges.size(), edgeCount);

        // Nodes 6, 3, 4
        assertTrue(vertices.contains(TestGraphFactory.getVertices().get(5)));
        assertTrue(vertices.contains(TestGraphFactory.getVertices().get(2)));
        assertTrue(vertices.contains(TestGraphFactory.getVertices().get(3)));

        // Edges d, e, f, g, h, i, j
        assertTrue(edges.contains(TestGraphFactory.getEdges().get(3)));
        assertTrue(edges.contains(TestGraphFactory.getEdges().get(4)));
        assertTrue(edges.contains(TestGraphFactory.getEdges().get(5)));
        assertTrue(edges.contains(TestGraphFactory.getEdges().get(6)));
        assertTrue(edges.contains(TestGraphFactory.getEdges().get(7)));
        assertTrue(edges.contains(TestGraphFactory.getEdges().get(8)));
        assertTrue(edges.contains(TestGraphFactory.getEdges().get(9)));
    }
}
