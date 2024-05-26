package com.embracket.aljorithm.DataStructures.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A simple graph, using an adjacency list. Can hold edges, which can be of any type.
 * @param <T> The type of nodes and edges contained.
 */
public class SimpleGraph<T> implements AbstractGraph<T> {
    private final boolean directed;
    private final Set<Edge<T>> edges;
    private final Set<Node<T>> nodes;
    private final Map<Node<T>, Set<Edge<T>>> adjacencyList;

    public SimpleGraph(Set<Edge<T>> edges){
        this.directed = edges.stream().toList().getFirst().isStrictlyDirected();
        this.edges = new HashSet<>();
        this.nodes = new HashSet<>();
        this.adjacencyList = new HashMap<>();

        addEdges(edges);
    }

    @Override
    public Set<Node<T>> neighbors(Node<T> node) {
        Set<Edge<T>> adjacencies = adjacencyList.getOrDefault(node, new HashSet<>());
        Set<Node<T>> neighbors = new HashSet<>();
        adjacencies.forEach(edge -> neighbors.add(edge.otherEnd(node)));
        return neighbors;
    }

    @Override
    public boolean isStrictlyDirected() {
        return directed;
    }

    @Override
    public Set<Edge<T>> getEdges() {
        return edges;
    }

    @Override
    public Set<Node<T>> getNodes() {
        return nodes;
    }

    private void addEdges(Set<Edge<T>> edges){
        edges.forEach(this::addEdge);
    }

    @Override
    public Edge<?> getEdge(Node<T> from, Node<T> to){
        Edge<?> result = new Edge<>(null,null); // A dummy edge
        for (Edge<T> edge : adjacencyList.get(from)){
            boolean strictlyConforms = edge.from().equals(from) && edge.to().equals(to);
            if (directed){
                result = strictlyConforms ? edge : result;
            } else {
                result = strictlyConforms || edge.from().equals(to) && edge.to().equals(from) ? edge : result;
            }
            if (strictlyConforms)
                break;
        }
        return result;
    }

    @Override
    public int V(){
        return nodes.size();
    }

    @Override
    public int E(){
        return edges.size();
    }

    @Override
    public boolean modifyGraph(Edge<T> edge, boolean remove) {
        Set<Edge<T>> fromAdjacencies = adjacencyList.getOrDefault(edge.from(), new HashSet<>());
        Set<Edge<T>> toAdjacencies = adjacencyList.getOrDefault(edge.to(), new HashSet<>());

        boolean impactful = true;

        if (!remove){
            fromAdjacencies.add(edge);
            edges.add(edge);
            nodes.add(edge.from());
            nodes.add(edge.to());
        } else {
            fromAdjacencies.remove(edge);
            impactful = edges.remove(edge); // The only impact this will ever have is if it removes an edge from the list
            nodes.remove(edge.from());
            nodes.remove(edge.to());
        }

        if (!directed){
            if(!remove){
                toAdjacencies.add(edge);
            } else {
                toAdjacencies.remove(edge);
            }
            adjacencyList.put(edge.to(), toAdjacencies);
        }
        adjacencyList.put(edge.from(), fromAdjacencies);

        return impactful;
    }

    @Override
    public boolean addEdge(Edge<T> edge) { return modifyGraph(edge, false); }
    @Override
    public boolean removeEdge(Edge<T> edge) { return modifyGraph(edge, true); }

    @Override
    public boolean containsNode(Node<T> query) {
        for (Node<T> node : nodes)
            if (node.equals(query)) // When we find any node, we break the loop
                return true; // And return "found"
        return false;
    }
    @Override
    public boolean containsEdge(Edge<T> query) {
        for (Edge<T> edge : edges)
            if (edge.equals(query)) // When we find any edge, we break the loop
                return true; // And return "found"
        return false;
    }

    @Override
    public boolean contains(Object object){
        if (object instanceof Edge<?> edge)
            return containsEdge((Edge<T>) edge); // Unsafe.. don't know to handle yet!
        else if (object instanceof Node<?> node)
            return  containsNode((Node<T>) node);
        return false;
    }
}
