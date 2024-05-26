package com.embracket.aljorithm.Algorithms.Pathfinding;

import com.embracket.aljorithm.DataStructures.Graph.*;

import java.util.*;

public class Dijkstras<T> {
    /**
     * Performs Dijkstras algorithm
     * Based on the following psuedocode:
     *
     * procedure dijkstras(G,start)
     * 	queue <- new priority queue
     * 	start.distTo <- 0
     *
     * 	for node v in G do
     * 			if v != start then
     * 				v.distTo <- infinity
     * 			add v to queue
     *
     * 	while queue not empty do
     * 		u <- take minimum from queue
     * 		for each neighbor v of u in G do
     * 			candidate <- u.distTo + (u,v).weight
     * 			if candidate < v.distTo then
     * 				v.distTo = candidate
     * 				v.pred = u
     * end
     *
     * @param graph A graph with directed edges
     * @param start The start node
     * @return      The costs found, as well as implicitly the predecessors, if any (empty if not)
     * @param <T>   The type of nodes
     */
    public static <T> Set<DijkstrasNode<T>> dijkstras(SimpleGraph<T> graph, Node<T> start){
        Map<Node<T>, DijkstrasNode<T>> wrappers = new HashMap<>();
        Queue<DijkstrasNode<T>> queue = new PriorityQueue<>();          // queue <- new priority queue

        for (Node<T> node : graph.getNodes()){                          // for node v in G do
            DijkstrasNode<T> wrapper = new DijkstrasNode<>(node);       // v.distTo <- infinity (implicit)
            if (node.equals(start))                                     // if v != start then
                wrapper.setDistance(0);                                 // start.distTo <- 0
            queue.add(wrapper);                                         // add v to queue
            wrappers.put(node,wrapper);
        }

        while (!queue.isEmpty()){
            DijkstrasNode<T> current = queue.poll();                    // take minimum from queue
            Node<T> item = current.getItem();
            for (Node<T> neighbor : graph.neighbors(item)){             // for each neighbor v of u in G do
                WeightedEdge<T> uv = (WeightedEdge<T>) graph.getEdge(neighbor,item);
                // (Cast is safe as we know the edge to be present and weighted)
                DijkstrasNode<T> nWrapper = wrappers.get(neighbor);
                double candidate = current.distance() + uv.getWeight(); // candidate <- u.distTo + (u,v).weight
                if (candidate < nWrapper.distance()){
                    nWrapper.setDistance(candidate);                    // v.distTo = candidate
                    nWrapper.setPred(item);                             // v.pred = u
                }
            }
        }
        return new HashSet<>(wrappers.values());                        // end
    }
}
