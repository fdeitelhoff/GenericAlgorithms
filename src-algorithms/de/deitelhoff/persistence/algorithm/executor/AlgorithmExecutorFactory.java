package de.deitelhoff.persistence.algorithm.executor;

import de.deitelhoff.persistence.algorithm.graph.data.NetworkEdge;
import de.deitelhoff.persistence.algorithm.graph.data.NetworkVertex;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 21:55
 */
public class AlgorithmExecutorFactory
{
    public static AlgorithmExecutor<NetworkVertex, NetworkEdge> createAlgorithmExecutor()
    {
        AlgorithmExecutor<NetworkVertex, NetworkEdge> algorithmExecutor
                = new AlgorithmExecutor<NetworkVertex, NetworkEdge>()
        {
            @Override
            public NetworkVertex retrieveStartVertex(NetworkEdge edge)
            {
                return edge.getStartVertex();
            }

            @Override
            public NetworkVertex retrieveEndVertex(NetworkEdge edge)
            {
                return edge.getEndVertex();
            }

            @Override
            public List<NetworkEdge> retrieveEdges(NetworkVertex vertex)
            {
                return vertex.getEdges();
            }

            @Override
            public double retrieveEdgeWeight(NetworkEdge edge)
            {
                return edge.getCosts();
            }
        };

        return algorithmExecutor;
    }
}
