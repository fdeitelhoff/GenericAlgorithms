package de.deitelhoff.persistence.algorithm.graph.data;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 22.05.12
 * Time: 21:36
 */
public class NetworkEdge
{
    private double costs;
    private NetworkVertex startVertex;
    private NetworkVertex endVertex;

    public NetworkEdge(double costs)
    {
        this.costs = costs;
    }

    public double getCosts()
    {
        return costs;
    }

    public NetworkVertex getEndVertex()
    {
        return endVertex;
    }

    public NetworkVertex getStartVertex()
    {
        return startVertex;
    }

    public void setStartVertex(NetworkVertex startVertex)
    {
        this.startVertex = startVertex;
    }

    public void setEndVertex(NetworkVertex endVertex)
    {
        this.endVertex = endVertex;
    }

    public String toString()
    {
        return "ResidualEdge: " + getStartVertex().getName() + " -> " + getEndVertex().getName();
    }
}
