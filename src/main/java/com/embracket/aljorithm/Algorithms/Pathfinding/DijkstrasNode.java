package com.embracket.aljorithm.Algorithms.Pathfinding;

import com.embracket.aljorithm.DataStructures.Graph.Node;

import java.util.Objects;

/**
 * A wrapper of Node, that adds a distance
 */
public class DijkstrasNode<T> implements Comparable<DijkstrasNode<T>>{ // Comparable, to work with priority queue
    private final Node<T> item; // The original node
    private double distance;
    private Node<T> pred; // The predecessors

    public DijkstrasNode(Node<T> item){
        this.item = item;
        pred = item;
        distance = Double.MAX_VALUE;
    }

    public DijkstrasNode(Node<T> item, double distance){
        this.item = item;
        pred = item;
        this.distance = distance;
    }

    public double distance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Node<T> getItem() {
        return item;
    }

    public Node<T> getPred() {
        return pred;
    }

    public void setPred(Node<T> pred) {
        this.pred = pred;
    }

    @Override
    public int hashCode() {
        return item.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        DijkstrasNode<T> node = (DijkstrasNode<T>) obj;
        return Objects.equals(item.getContent(), node.getItem().getContent())
                && Objects.equals(distance, node.distance());
        // A dijkstra node with the same content and distance is considered equal
    }

    @Override // Necessary for comparable
    public int compareTo(DijkstrasNode<T> o) {
        return (int) Math.round(o.distance() - distance);
    }

    @Override
    public String toString() {
        return item.toString() + "[ Distance = " + distance + "]";
    }
}
