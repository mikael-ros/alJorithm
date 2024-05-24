package com.embracket.aljorithm.DataStructures.Graph;

import java.util.Map;
import java.util.Set;

public class SimpleGraph<T> implements Graph<T>{
    private boolean directed;
    private Set<Edge<T>> edges;
    private Set<Node<T>> nodes;
    private Map<Node<T>, Set<Edge<T>>> adjacencyList;

    public SimpleGraph(Set<Edge<T>> edges){

    }

    @Override
    public Set<Node> neighbors(Node node) {
        return null;
    }

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public Set<Edge<T>> getEdges() {
        return null;
    }

    @Override
    public Set<Node<T>> getNodes() {
        return null;
    }

    @Override
    public boolean modifyGraph(Edge<T> edge, boolean remove) {
        return false;
    }

    @Override
    public boolean addEdge(Edge<T> edge) {
        return false;
    }

    @Override
    public boolean removeEdge(Edge<T> edge) {
        return false;
    }

    @Override
    public boolean containsNode(Node node) {
        return false;
    }

    @Override
    public boolean containsEdge(Edge edge) {
        return false;
    }
}
