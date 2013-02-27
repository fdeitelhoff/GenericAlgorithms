package de.deitelhoff.persistence.algorithm.graph.data;

import java.util.List;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 20:14
 */
public class TestGraphFactory
{
    private static List<NetworkVertex> vertices;
    private static List<NetworkEdge> edges;

    public static NetworkVertex createTestGraph()
    {
        vertices = new Vector<>();
        edges = new Vector<>();

        NetworkVertex vertex1 = new NetworkVertex("Node 1");
        NetworkVertex vertex2 = new NetworkVertex("Node 2");
        NetworkVertex vertex3 = new NetworkVertex("Node 3");
        NetworkVertex vertex4 = new NetworkVertex("Node 4");
        NetworkVertex vertex5 = new NetworkVertex("Node 5");
        NetworkVertex vertex6 = new NetworkVertex("Node 6");

        vertices.add(vertex1);
        vertices.add(vertex2);
        vertices.add(vertex3);
        vertices.add(vertex4);
        vertices.add(vertex5);
        vertices.add(vertex6);

        NetworkEdge edge1To2 = new NetworkEdge(2);
        NetworkEdge edge2To3 = new NetworkEdge(1);
        NetworkEdge edge3To4 = new NetworkEdge(9);
        NetworkEdge edge3To4_second = new NetworkEdge(8);
        NetworkEdge edge1To5 = new NetworkEdge(3);
        NetworkEdge edge2To5 = new NetworkEdge(4);
        NetworkEdge edge2To4 = new NetworkEdge(3);
        NetworkEdge edge2To6 = new NetworkEdge(5);
        NetworkEdge edge5To3 = new NetworkEdge(11);
        NetworkEdge edge6To3 = new NetworkEdge(6);

        edges.add(edge1To2);
        edges.add(edge1To5);
        edges.add(edge2To5);
        edges.add(edge2To6);
        edges.add(edge5To3);
        edges.add(edge6To3);
        edges.add(edge2To3);
        edges.add(edge2To4);
        edges.add(edge3To4);
        edges.add(edge3To4_second);

        vertex1.addStartEdge(edge1To2);
        vertex2.addEndEdge(edge1To2);

        vertex2.addStartEdge(edge2To3);
        vertex3.addEndEdge(edge2To3);

        vertex3.addStartEdge(edge3To4);
        vertex4.addEndEdge(edge3To4);

        vertex3.addStartEdge(edge3To4_second);
        vertex4.addEndEdge(edge3To4_second);

        vertex1.addStartEdge(edge1To5);
        vertex5.addEndEdge(edge1To5);

        vertex2.addStartEdge(edge2To5);
        vertex5.addEndEdge(edge2To5);

        vertex2.addStartEdge(edge2To4);
        vertex4.addEndEdge(edge2To4);

        vertex2.addStartEdge(edge2To6);
        vertex6.addEndEdge(edge2To6);

        vertex5.addStartEdge(edge5To3);
        vertex3.addEndEdge(edge5To3);

        vertex6.addStartEdge(edge6To3);
        vertex3.addEndEdge(edge6To3);

        return vertex1;
    }

    public static NetworkVertex createSimpleTestGraph()
    {
        vertices = new Vector<>();
        edges = new Vector<>();

        NetworkVertex vertex1 = new NetworkVertex("Node 1");
        NetworkVertex vertex2 = new NetworkVertex("Node 2");

        vertices.add(vertex1);
        vertices.add(vertex2);

        NetworkEdge edge1To2 = new NetworkEdge(10);

        edges.add(edge1To2);

        vertex1.addStartEdge(edge1To2);
        vertex2.addEndEdge(edge1To2);

        return vertex1;
    }

    public static NetworkVertex createEmptyTestGraph()
    {
        vertices = new Vector<>();
        edges = new Vector<>();

        return null;
    }

    public static NetworkVertex createOneVertexTestGraph()
    {
        vertices = new Vector<>();
        edges = new Vector<>();

        NetworkVertex vertex1 = new NetworkVertex("Node 1");

        vertices.add(vertex1);

        return vertex1;
    }

    public static List<NetworkVertex> getVertices()
    {
        return vertices;
    }

    public static List<NetworkEdge> getEdges()
    {
        return edges;
    }
}
