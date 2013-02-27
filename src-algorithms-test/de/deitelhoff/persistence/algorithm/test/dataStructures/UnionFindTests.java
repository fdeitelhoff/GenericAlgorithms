package de.deitelhoff.persistence.algorithm.test.dataStructures;

import de.deitelhoff.persistence.algorithm.dataStructure.UnionFind;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkVertex;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 22.05.12
 * Time: 22:54
 */
public class UnionFindTests
{
    @Test
    public void unionFindOneSetTest()
    {
        // Arrange
        final NetworkVertex vertex1 = new NetworkVertex("Node 1");

        final UnionFind<NetworkVertex> unionFind = new UnionFind<>();

        // Act
        unionFind.makeSet(vertex1);

        // Assert
        assertEquals(unionFind.getSets().size(), 1);
        assertEquals(unionFind.find(vertex1), vertex1);
    }

    @Test
    public void unionFindNoMatchTest()
    {
        // Arrange
        final NetworkVertex vertex1 = new NetworkVertex("Node 1");
        final NetworkVertex vertex2 = new NetworkVertex("Node 2");

        final UnionFind<NetworkVertex> unionFind = new UnionFind<>();

        // Act
        unionFind.makeSet(vertex1);
        final NetworkVertex networkVertex = unionFind.find(vertex2);

        // Assert
        assertEquals(unionFind.getSets().size(), 1);
        assertNull(networkVertex);
    }
}
