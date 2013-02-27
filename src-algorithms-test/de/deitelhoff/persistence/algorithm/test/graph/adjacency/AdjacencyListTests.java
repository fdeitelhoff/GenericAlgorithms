package de.deitelhoff.persistence.algorithm.test.graph.adjacency;

import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutorFactory;
import de.deitelhoff.persistence.algorithm.graph.adjacency.AdjacencyListResult;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkEdge;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkVertex;
import de.deitelhoff.persistence.algorithm.graph.data.TestGraphFactory;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 02.06.12
 * Time: 22:02
 */
public class AdjacencyListTests
{
    @Test
    public void testGraphAdjacencyListTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createTestGraph();
        final List<NetworkVertex> vertices = TestGraphFactory.getVertices();
        final List<NetworkEdge> edges = TestGraphFactory.getEdges();
        final int vertexCount = 6;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final AdjacencyListResult<NetworkVertex, NetworkEdge> adjacencyListResult
                = algorithmExecutor.start("adjacencylist", firstVertex).getAdjacencyListResult();
        final HashMap<NetworkVertex, List<NetworkEdge>> adjacencyList = adjacencyListResult.getAdjacencyList();
        final int adjacencyVertexCount = adjacencyList.size();

        // Assert
        assertNotNull(adjacencyListResult);
        assertEquals(adjacencyVertexCount, vertexCount);

        // From Node 1
        assertEquals(adjacencyList.get(vertices.get(0)).size(), 2);
        assertTrue(adjacencyList.get(vertices.get(0)).contains(edges.get(0)));
        assertTrue(adjacencyList.get(vertices.get(0)).contains(edges.get(1)));

        // From Node 2
        assertEquals(adjacencyList.get(vertices.get(1)).size(), 4);
        assertTrue(adjacencyList.get(vertices.get(1)).contains(edges.get(2)));
        assertTrue(adjacencyList.get(vertices.get(1)).contains(edges.get(3)));
        assertTrue(adjacencyList.get(vertices.get(1)).contains(edges.get(6)));
        assertTrue(adjacencyList.get(vertices.get(1)).contains(edges.get(7)));

        // From Node 3
        assertEquals(adjacencyList.get(vertices.get(2)).size(), 2);
        assertTrue(adjacencyList.get(vertices.get(2)).contains(edges.get(8)));
        assertTrue(adjacencyList.get(vertices.get(2)).contains(edges.get(9)));

        // From Node 4
        assertEquals(adjacencyList.get(vertices.get(3)).size(), 0);

        // From Node 5
        assertEquals(adjacencyList.get(vertices.get(4)).size(), 1);
        assertTrue(adjacencyList.get(vertices.get(4)).contains(edges.get(4)));

        // From Node 6
        assertEquals(adjacencyList.get(vertices.get(5)).size(), 1);
        assertTrue(adjacencyList.get(vertices.get(5)).contains(edges.get(5)));
    }

    @Test(expected = IllegalGraphException.class)
    public void emptyGraphAdjacencyListTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createEmptyTestGraph();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start("adjacencylist", firstVertex).getAdjacencyListResult();
    }

    @Test
    public void simpleGraphAdjacencyListTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createSimpleTestGraph();
        final List<NetworkVertex> vertices = TestGraphFactory.getVertices();
        final List<NetworkEdge> edges = TestGraphFactory.getEdges();
        final int vertexCount = 2;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final AdjacencyListResult<NetworkVertex, NetworkEdge> adjacencyListResult
                = algorithmExecutor.start("adjacencylist", firstVertex).getAdjacencyListResult();
        final HashMap<NetworkVertex, List<NetworkEdge>> adjacencyList = adjacencyListResult.getAdjacencyList();
        final int adjacencyVertexCount = adjacencyList.size();

        // Assert
        assertNotNull(adjacencyListResult);
        assertEquals(adjacencyVertexCount, vertexCount);

        // From Node 1
        assertEquals(adjacencyList.get(vertices.get(0)).size(), 1);
        assertTrue(adjacencyList.get(vertices.get(0)).contains(edges.get(0)));

        // From Node 2
        assertEquals(adjacencyList.get(vertices.get(1)).size(), 0);
    }

    @Test
    public void oneVertexGraphAdjacencyListTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createOneVertexTestGraph();
        final List<NetworkVertex> vertices = TestGraphFactory.getVertices();
        final int vertexCount = 1;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final AdjacencyListResult<NetworkVertex, NetworkEdge> adjacencyListResult
                = algorithmExecutor.start("adjacencylist", firstVertex).getAdjacencyListResult();
        final HashMap<NetworkVertex, List<NetworkEdge>> adjacencyList = adjacencyListResult.getAdjacencyList();
        final int adjacencyVertexCount = adjacencyList.size();

        // Assert
        assertNotNull(adjacencyListResult);
        assertEquals(adjacencyVertexCount, vertexCount);

        // From Node 1
        assertEquals(adjacencyList.get(vertices.get(0)).size(), 0);
    }
}
