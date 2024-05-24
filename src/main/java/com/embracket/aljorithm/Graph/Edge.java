package com.embracket.aljorithm.Graph;

import com.embracket.aljorithm.Util.Pair;

import java.util.Objects;

public class Edge<T> extends Pair<Node<T>> {
    private final boolean directed;

    public Edge(Node<T> first, Node<T> second) {
        super(first, second);
        this.directed = false;
    }

    public Edge(Node<T> first, Node<T> second, boolean directed){
        super(first,second);
        this.directed = directed;
    }

    public Node<T> from(){
        return fst();
    }

    public Node<T> to(){
        return snd();
    }

    public boolean isDirected() {
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
        return obj instanceof Edge<?> other
                && other.from().equals(from())
                && other.to().equals(to())
                && other.isDirected() == directed;
        // An edge with the same nodes and direction status is considered equal
    }
}
