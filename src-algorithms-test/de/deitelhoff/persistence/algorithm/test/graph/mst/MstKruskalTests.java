package de.deitelhoff.persistence.algorithm.test.graph.mst;

import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutor;
import de.deitelhoff.persistence.algorithm.executor.AlgorithmExecutorFactory;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkEdge;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkVertex;
import de.deitelhoff.persistence.algorithm.graph.data.TestGraphFactory;
import de.deitelhoff.persistence.algorithm.graph.errorHandling.IllegalGraphException;
import de.deitelhoff.persistence.algorithm.graph.mst.MstResult;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 22.05.12
 * Time: 22:35
 */
public class MstKruskalTests
{
    @Test
    public void testGraphMSTFirstVertexTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createTestGraph();
        final List<NetworkEdge> edges = TestGraphFactory.getEdges();
        final int mstCount = 5;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final MstResult<NetworkEdge> mstResult = algorithmExecutor.start("mst", firstVertex).getMstResult();
        final List<NetworkEdge> minimumSpanningTree = mstResult.getMinimumSpanningTree();

        // Assert
        assertNotNull(mstResult);
        assertEquals(minimumSpanningTree.size(), mstCount);
        assertTrue(minimumSpanningTree.contains(edges.get(0)));
        assertTrue(minimumSpanningTree.contains(edges.get(1)));
        assertTrue(minimumSpanningTree.contains(edges.get(3)));
        assertTrue(minimumSpanningTree.contains(edges.get(6)));
        assertTrue(minimumSpanningTree.contains(edges.get(7)));
    }

    @Test
    public void testGraphMSTSixthVertexTest() throws IllegalGraphException
    {
        // Arrange
        TestGraphFactory.createTestGraph();
        final NetworkVertex sixthVertex = TestGraphFactory.getVertices().get(5);
        final List<NetworkEdge> edges = TestGraphFactory.getEdges();
        final int mstCount = 5;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final MstResult<NetworkEdge> mstResult = algorithmExecutor.start("mst", sixthVertex).getMstResult();
        final List<NetworkEdge> minimumSpanningTree = mstResult.getMinimumSpanningTree();

        // Assert
        assertNotNull(mstResult);
        assertEquals(minimumSpanningTree.size(), mstCount);
        assertTrue(minimumSpanningTree.contains(edges.get(0)));
        assertTrue(minimumSpanningTree.contains(edges.get(1)));
        assertTrue(minimumSpanningTree.contains(edges.get(3)));
        assertTrue(minimumSpanningTree.contains(edges.get(6)));
        assertTrue(minimumSpanningTree.contains(edges.get(7)));
    }

    @Test(expected = IllegalGraphException.class)
    public void testGraphMSTOneVertexTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createOneVertexTestGraph();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start("mst", firstVertex).getMstResult();
    }

    @Test(expected = IllegalGraphException.class)
    public void testGraphMSTEmptyGraphTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createEmptyTestGraph();

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        algorithmExecutor.start("mst", firstVertex).getMstResult();
    }

    @Test
    public void testGraphMSTSimpleGraphTest() throws IllegalGraphException
    {
        // Arrange
        final NetworkVertex firstVertex = TestGraphFactory.createSimpleTestGraph();
        final List<NetworkEdge> edges = TestGraphFactory.getEdges();
        final int mstCount = 1;

        final AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor = AlgorithmExecutorFactory.createAlgorithmExecutor();

        // Act
        final MstResult<NetworkEdge> mstResult = algorithmExecutor.start("mst", firstVertex).getMstResult();
        final List<NetworkEdge> minimumSpanningTree = mstResult.getMinimumSpanningTree();

        // Assert
        assertNotNull(mstResult);
        assertEquals(minimumSpanningTree.size(), mstCount);
        assertTrue(minimumSpanningTree.contains(edges.get(0)));
    }
}
