package de.deitelhoff.persistence.algorithm.graph.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 22.05.12
 * Time: 21:35
 */
public class NetworkVertex
{
    private final String name;
    private final List<NetworkEdge> edges;

    public NetworkVertex(final String name)
    {
        this.name = name;
        this.edges = new ArrayList<>();
    }

    public void addStartEdge(NetworkEdge startEdge)
    {
        if (!edges.contains(startEdge))
        {
            edges.add(startEdge);

            startEdge.setStartVertex(this);
        }
    }

    public void addEndEdge(NetworkEdge endEdge)
    {
        if (!edges.contains(endEdge))
        {
            edges.add(endEdge);

            endEdge.setEndVertex(this);
        }
    }

    public List<NetworkEdge> getEdges()
    {
        return edges;
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return "Node: " + getName();
    }
}
