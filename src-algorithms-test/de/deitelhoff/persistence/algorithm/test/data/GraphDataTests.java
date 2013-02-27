package de.deitelhoff.persistence.algorithm.test.data;

import de.deitelhoff.persistence.algorithm.graph.data.NetworkEdge;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkVertex;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 03.06.12
 * Time: 00:26
 */
public class GraphDataTests
{
    @Test
    public void simpleGraphDataTest()
    {
        // Arrange
        NetworkVertex vertex1 = new NetworkVertex("Node 1");
        NetworkVertex vertex2 = new NetworkVertex("Node 2");

        NetworkEdge edge1To2 = new NetworkEdge(5);

        // Act
        vertex1.addStartEdge(edge1To2);
        vertex2.addEndEdge(edge1To2);

        // Assert
        assertEquals(vertex1.getName(), "Node 1");
        assertEquals(vertex2.getName(), "Node 2");

        assertEquals(edge1To2.getCosts(), 5, 0);

        assertEquals(vertex1.getEdges().size(), 1);

        assertEquals(edge1To2.getStartVertex(), vertex1);
        assertEquals(edge1To2.getEndVertex(), vertex2);

        assertEquals(vertex1.toString(), "Node: " + vertex1.getName());
        assertEquals(vertex2.toString(), "Node: " + vertex2.getName());

        assertEquals(edge1To2.toString(), "ResidualEdge: " + vertex1.getName() + " -> " + vertex2.getName());
    }
}
