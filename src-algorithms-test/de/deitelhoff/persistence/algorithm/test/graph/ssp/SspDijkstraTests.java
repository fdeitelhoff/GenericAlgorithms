package de.deitelhoff.persistence.algorithm.test.graph.ssp;

import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutorFactory;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkEdge;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkVertex;
import de.deitelhoff.persistence.algorithm.graph.data.TestGraphFactory;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.graph.ssp.SspResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 02.06.12
 * Time: 21:57
 */
public class SspDijkstraTests
{
    @Test
    public void testGraphSspTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createTestGraph();
        final NetworkVertex startVertex = firstVertex;
        final List<NetworkVertex> vertices = TestGraphFactory.getVertices();
        final List<NetworkEdge> edges = TestGraphFactory.getEdges();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final SspResult<NetworkVertex, NetworkEdge> sspResult
                = algorithmExecutor.start("ssp", firstVertex, startVertex).getSspResult();
        final HashMap<NetworkVertex, List<NetworkEdge>> shortesPaths = sspResult.getShortestPaths();

        // Assert
        assertNotNull(sspResult);

        assertEquals(shortesPaths.size(), 6);

        // Node 1 -> 1
        assertEquals(shortesPaths.get(vertices.get(0)).size(), 0);

        // Node 1 -> 2
        assertEquals(shortesPaths.get(vertices.get(1)).size(), 1);
        assertTrue(shortesPaths.get(vertices.get(1)).contains(edges.get(0)));

        // Node 1 -> 5
        assertEquals(shortesPaths.get(vertices.get(4)).size(), 1);
        assertTrue(shortesPaths.get(vertices.get(4)).contains(edges.get(1)));

        // Node 1 -> 6
        assertEquals(shortesPaths.get(vertices.get(5)).size(), 2);
        assertTrue(shortesPaths.get(vertices.get(5)).contains(edges.get(0)));
        assertTrue(shortesPaths.get(vertices.get(5)).contains(edges.get(3)));

        // Node 1 -> 3
        assertEquals(shortesPaths.get(vertices.get(2)).size(), 2);
        assertTrue(shortesPaths.get(vertices.get(2)).contains(edges.get(0)));
        assertTrue(shortesPaths.get(vertices.get(2)).contains(edges.get(6)));

        // Node 1 -> 4
        assertEquals(shortesPaths.get(vertices.get(3)).size(), 2);
        assertTrue(shortesPaths.get(vertices.get(3)).contains(edges.get(0)));
        assertTrue(shortesPaths.get(vertices.get(3)).contains(edges.get(7)));
    }

    @Test(expected = IllegalGraphException.class)
    public void emptyGraphSspTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createEmptyTestGraph();
        final NetworkVertex startVertex = firstVertex;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start("ssp", firstVertex, startVertex).getSspResult();
    }

    @Test
    public void oneVertexGraphSspTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createOneVertexTestGraph();
        final NetworkVertex startVertex = firstVertex;
        final List<NetworkVertex> vertices = TestGraphFactory.getVertices();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final SspResult<NetworkVertex, NetworkEdge> sspResult
                = algorithmExecutor.start("ssp", firstVertex, startVertex).getSspResult();
        final HashMap<NetworkVertex, List<NetworkEdge>> shortesPaths = sspResult.getShortestPaths();

        // Assert
        assertNotNull(sspResult);

        assertEquals(shortesPaths.size(), 1);

        // Node 1 -> 1
        assertEquals(shortesPaths.get(vertices.get(0)).size(), 0);
    }

    @Test
    public void simpleGraphSspTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createSimpleTestGraph();
        final NetworkVertex startVertex = firstVertex;
        final List<NetworkVertex> vertices = TestGraphFactory.getVertices();
        final List<NetworkEdge> edges = TestGraphFactory.getEdges();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final SspResult<NetworkVertex, NetworkEdge> sspResult
                = algorithmExecutor.start("ssp", firstVertex, startVertex).getSspResult();
        final HashMap<NetworkVertex, List<NetworkEdge>> shortesPaths = sspResult.getShortestPaths();

        // Assert
        assertNotNull(sspResult);

        assertEquals(shortesPaths.size(), 2);

        // Node 1 -> 1
        assertEquals(shortesPaths.get(vertices.get(0)).size(), 0);

        // Node 1 -> 2
        assertEquals(shortesPaths.get(vertices.get(1)).size(), 1);
        assertTrue(shortesPaths.get(vertices.get(1)).contains(edges.get(0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyStartVertexGraphSspTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createTestGraph();
        final NetworkVertex startVertex = null;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start("ssp", firstVertex, startVertex).getSspResult();
    }
}

