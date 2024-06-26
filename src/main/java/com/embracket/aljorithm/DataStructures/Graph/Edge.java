package com.embracket.aljorithm.DataStructures.Graph;

import com.embracket.aljorithm.DataStructures.Util.Pair;

import java.util.Objects;

public class Edge<T> extends Pair<Node<T>> implements AbstractEdge<T> {
    private final boolean directed;

    public Edge(Node<T> first, Node<T> second) {
        super(first, second);
        this.directed = false;
    }

    public Edge(Node<T> first, Node<T> second, boolean directed){
        super(first,second);
        this.directed = directed;
    }

    /**
     * Shorthand constructor, that makes the nodes itself
     * @param first Content of first node
     * @param second Content of second node
     */
    public Edge(T first, T second){
        super(new Node<>(first), new Node<>(second));
        this.directed = false;
    }

    public Edge(T first, T second, boolean directed){
        super(new Node<>(first), new Node<>(second));
        this.directed = directed;
    }

    public Node<T> from(){
        return fst();
    }

    public Node<T> to(){
        return snd();
    }

    public Node<T> otherEnd(Node<T> oneEnd){
        return other(oneEnd);
    }

    public boolean isStrictlyDirected() {
        return directed;
    }

    @Override
    public String toString() {
        String arrow = directed ? " ---> " : " <---> ";
        return fst() + arrow + snd();
    }

    @Override
    public int hashCode() {
        return Objects.hash(fst(),snd(),directed);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Edge<T> edge = (Edge<T>) obj;
        return      Objects.equals(from(), edge.from())
                &&  Objects.equals(to(), edge.to())
                &&  Objects.equals(directed, edge.isStrictlyDirected());
        // An edge with the same nodes and direction status is considered equal
    }
}
