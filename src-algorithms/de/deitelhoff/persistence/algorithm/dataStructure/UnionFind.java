package de.deitelhoff.persistence.algorithm.dataStructure;

/**
 * Created with IntelliJ IDEA.
 * User: Fabian Deitelhoff
 * Date: 22.05.12
 * Time: 22:04
 */

import java.util.List;
import java.util.Vector;

public class UnionFind<V>
{
    private Vector<Vector<V>> sets;

    public UnionFind()
    {
        sets = new Vector<>();
    }

    public UnionFind(final List<V> vertices)
    {
        this();

        makeSets(vertices);
    }

    public void makeSet(final V vertex)
    {
        Vector<V> t = new Vector<>();
        t.add(vertex);
        sets.add(t);
    }

    public void makeSets(final List<V> vertices)
    {
        for (final V vertex : vertices)
        {
            makeSet(vertex);
        }
    }

    public V find(final V vector)
    {
        for (final Vector<V> set : sets)
        {
            if (set.contains(vector))
            {
                return set.firstElement();
            }
        }

        return null;
    }

    public void union(final V firstVertex, final V secondVertex)
    {
        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 0; i < this.sets.size(); i++)
        {
            if (this.sets.get(i).contains(firstVertex))
            {
                firstIndex = i;
            }
            if (this.sets.get(i).contains(secondVertex))
            {
                secondIndex = i;
            }
        }

        this.sets.get(firstIndex).addAll(this.sets.remove(secondIndex));
    }

    public Vector<Vector<V>> getSets()
    {
        return sets;
    }
}