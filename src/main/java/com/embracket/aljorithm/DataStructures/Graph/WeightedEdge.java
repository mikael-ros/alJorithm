package com.embracket.aljorithm.DataStructures.Graph;

import java.util.Objects;

/**
 * An edge with weight
 * @param <T> The type of node
 */
public class WeightedEdge<T> extends Edge<T> implements AbstractEdge<T> {
    private final int weight;
    public WeightedEdge(Node<T> first, Node<T> second, int weight) {
        super(first, second);
        this.weight = weight;
    }

    public WeightedEdge(Node<T> first, Node<T> second, int weight, boolean directed) {
        super(first, second, directed);
        this.weight = weight;
    }

    public WeightedEdge(T first, T second, int weight) {
        super(first, second);
        this.weight = weight;
    }

    public WeightedEdge(T first, T second, int weight, boolean directed) {
        super(first, second, directed);
        this.weight = weight;
    }

    public int getWeight() { return weight; }

    @Override
    public String toString() {
        String arrow = isStrictlyDirected() ? " ---> " : " <---> ";
        return fst() + arrow + snd() + " [Weight = " + weight + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(fst(),snd(),isStrictlyDirected(), weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        WeightedEdge<T> edge = (WeightedEdge<T>) obj;
        return      Objects.equals(from(), edge.from())
                &&  Objects.equals(to(), edge.to())
                &&  Objects.equals(isStrictlyDirected(), edge.isStrictlyDirected())
                &&  Objects.equals(weight, edge.getWeight());
        // An edge with the same nodes and direction status is considered equal
    }
}
