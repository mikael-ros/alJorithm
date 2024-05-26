package com.embracket.aljorithm.Algorithms.Pathfinding;

import com.embracket.aljorithm.DataStructures.Graph.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.embracket.aljorithm.Algorithms.Pathfinding.Dijkstras.dijkstras;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestDijkstras {

    Set<DijkstrasNode<Integer>> predictedCostsGraph1;
    SimpleGraph<Integer> graph1;
    Set<Edge<Integer>> edges1;
    @BeforeEach
    void setUp() {
        // Graph 1
        // Based on https://neetcode.io/problems/dijkstra:
        // //  Input:
        // //  n = 5
        // //  edges = [[0,1,10], [0,2,3], [1,3,2], [2,1,4], [2,3,8], [2,4,2], [3,4,5]]
        // //  src = 0
        // //
        // //  Output:
        // //  {{0:0}, {1:7}, {2:3}, {3:9}, {4:5}}
        edges1 = new HashSet<>();
        edges1.add(new WeightedEdge<>(0,1,10));
        edges1.add(new WeightedEdge<>(0,2,3));
        edges1.add(new WeightedEdge<>(1,3,2));
        edges1.add(new WeightedEdge<>(2,1,4));
        edges1.add(new WeightedEdge<>(2,3,8));
        edges1.add(new WeightedEdge<>(2,4,2));
        edges1.add(new WeightedEdge<>(3,4,5));

        graph1 = new SimpleGraph<>(edges1);

        predictedCostsGraph1 = new HashSet<>();
        predictedCostsGraph1.add(new DijkstrasNode<>(new Node<>(0), 0.0));
        predictedCostsGraph1.add(new DijkstrasNode<>(new Node<>(1), 7.0));
        predictedCostsGraph1.add(new DijkstrasNode<>(new Node<>(2), 3.0));
        predictedCostsGraph1.add(new DijkstrasNode<>(new Node<>(3), 9.0));
        predictedCostsGraph1.add(new DijkstrasNode<>(new Node<>(4), 5.0));
    }

    @Test
    @DisplayName("Dijkstas finds the correct paths")
    void correctSolutionGraph1(){
        assertEquals(predictedCostsGraph1, dijkstras(graph1, new Node<>(0)));
    }
}
