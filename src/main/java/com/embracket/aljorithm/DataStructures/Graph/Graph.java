package com.embracket.aljorithm.DataStructures.Graph;

import java.util.Set;

/**
 * Any type of graph, could be implemented in any way, as long as it satisfies these methods
 * @param <T> The type of the nodes contained
 */
public interface Graph<T> {
    /**
     * Should return the neighbors of a node
     * @param node The node queried
     * @return The neighbors
     */
    Set<Node<T>> neighbors(Node<T> node);

    boolean isDirected();

    String toString();

    /**
     * Whether this graph contains a specified node
     * @param query The node queried
     * @return Whether it is in the graph
     */
    boolean containsNode(Node<T> query);

    /**
     * Whether this graph contains a specified edge
     * @param query The edge queried
     * @return Whether it is in the graph
     */
    boolean containsEdge(Edge<T> query);

    /**
     * A general contains. Will, if object is edge or node, run the containsEdge or containsNode method.
     * @param object The object queried
     * @return Returns whether object is in some way in graph. False if object isn't node or edge.
     */
    boolean contains(Object object);

    Set<Edge<T>> getEdges();
    Set<Node<T>> getNodes();

    /**
     * Does an operation based on the remove parameter
     * @param edge The edge to remove or add
     * @param remove Whether to remove or add (true => remove)
     * @return Whether it was successful/impactful
     */
    boolean modifyGraph(Edge<T> edge, boolean remove);

    /**
     * Adds an edge, if it's not contained within
     * @param edge The edge
     * @return Whether it wasn't in the graph or if it was
     */
    boolean addEdge(Edge<T> edge);

    /**
     * Removes an edge, if it's contained within
     * @param edge The edge
     * @return Whether it was in the graph or not
     */
    boolean removeEdge(Edge<T> edge);
}
