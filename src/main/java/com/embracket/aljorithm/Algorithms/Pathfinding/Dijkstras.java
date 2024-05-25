package com.embracket.aljorithm.Algorithms.Pathfinding;

import com.embracket.aljorithm.DataStructures.Graph.*;

import java.util.*;

public class Dijkstras<T> {
    /**
     * Performs Dijkstras algorithm
     * Based on the following psuedocode:
     *
     * procedure dijkstras(G,start)
     * 	visited <- new set
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
     * @return      The paths found, if any (empty if not)
     * @param <T>   The type of nodes
     */
    public static <T> Map<Node<T>, Path<T>> dijkstras(SimpleGraph<T> graph, Node<T> start){
        Map<Node<T>, Path<T>> preds = new HashMap<>();

        Queue<Node<T>> queue = new PriorityQueue<>();                   // queue <- new priority queue

        Map<Node<T>, Double> distances = new HashMap<>();
        distances.put(start, 0.0);                                      // start.distTo <- 0
        for (Node<T> node : graph.getNodes()){                          // for node v in G do
            if (!node.equals(start))                                    // if v != start then
                distances.put(node, Double.MAX_VALUE);                  // v.distTo <- infinity
            queue.add(node);                                            // add v to queue
        }

        while (!queue.isEmpty()){
            Node<T> current = queue.poll();                             // take minimum from queue
            for (Node<T> neighbor : graph.neighbors(current)){          // for each neighbor v of u in G do
                WeightedEdge<T> uv = (WeightedEdge<T>) graph.getEdge(neighbor,current);
                // (Cast is safe as we know the edge to be present and weighted)
                double candidate =                                      // candidate <- u.distTo + (u,v).weight
                        distances.get(current)
                        + uv.getWeight();
                if (candidate < distances.get(neighbor)){
                    distances.put(neighbor, candidate);                 // v.distTo = candidate
                    Path<T> pred = preds.getOrDefault(neighbor, new Path<T>());
                    pred.add(uv);                                       // v.pred = u
                }
            }
        }
        return preds;                                                   // end
    }
}
