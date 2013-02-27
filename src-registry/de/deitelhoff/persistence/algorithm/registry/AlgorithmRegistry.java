package de.deitelhoff.persistence.algorithm.registry;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 23.05.12
 * Time: 15:08
 */
public class AlgorithmRegistry<T>
{
    private HashMap<String, T> algorithms;

    public AlgorithmRegistry()
    {
        algorithms = new HashMap<>();
    }

    public void addAlgorithm(String key, T value)
    {
        algorithms.put(key, value);
    }

    public T getAlgorithm(String key)
    {
        return algorithms.get(key);
    }

    public boolean algorithmExists(String key)
    {
        return algorithms.containsKey(key);
    }
}
