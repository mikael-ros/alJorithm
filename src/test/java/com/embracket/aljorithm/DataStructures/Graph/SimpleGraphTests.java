package com.embracket.aljorithm.DataStructures.Graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class SimpleGraphTests {
    Set<Node<Integer>> nodes;
    Set<Node<Integer>> directedNodes;
    Node<Integer> node1 = new Node(1);
    Set<Node<Integer>> node1Neighbors;
    Set<Node<Integer>> directedNode1Neighbors;
    Set<Edge<Integer>> node1Adjacencies;
    Set<Edge<Integer>> directedNode1Adjacencies;
    Node<Integer> node2 = new Node(2);
    Set<Node<Integer>> node2Neighbors;
    Set<Node<Integer>> directedNode2Neighbors;
    Set<Edge<Integer>> node2Adjacencies;
    Set<Edge<Integer>> directedNode2Adjacencies;
    Node<Integer> node3 = new Node(3);
    Set<Node<Integer>> node3Neighbors;
    Set<Node<Integer>> directedNode3Neighbors;
    Set<Edge<Integer>> node3Adjacencies;
    Set<Edge<Integer>> directedNode3Adjacencies;
    Node<Integer> node4 = new Node(4);
    Set<Node<Integer>> directedNode4Neighbors;
    Set<Edge<Integer>> directedNode4Adjacencies;

    Graph<Integer> graph;
    Graph<Integer> directedGraph;
    Set<Edge<Integer>> edges;
    Set<Edge<Integer>> directedEdges;
    Map<Node<Integer>, Set<Edge<Integer>>> adjacencyList;
    Map<Node<Integer>, Set<Edge<Integer>>> directedAdjacencyList;

    @BeforeEach
    void setUp() {
        // Construct undirected graph
        edges = new HashSet<>();

        adjacencyList = new HashMap<>();

        nodes = new HashSet<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);

        // Manual adjacencies
        node1Adjacencies = new HashSet<>();
        node1Neighbors = new HashSet<>();
        node2Adjacencies = new HashSet<>();
        node2Neighbors = new HashSet<>();
        node3Adjacencies = new HashSet<>();
        node3Neighbors = new HashSet<>();

        Edge<Integer> edge1 = new Edge<>(1,2);
        node1Adjacencies.add(edge1);
        node2Adjacencies.add(edge1);
        node1Neighbors.add(node2);
        node2Neighbors.add(node1);
        Edge<Integer> edge2 = new Edge<>(2,3);
        node2Adjacencies.add(edge2);
        node3Adjacencies.add(edge2);
        node2Neighbors.add(node3);
        node3Neighbors.add(node2);
        Edge<Integer> edge3 = new Edge<>(3,1);
        node1Adjacencies.add(edge3);
        node3Adjacencies.add(edge3);
        node3Neighbors.add(node1);
        node1Neighbors.add(node3);
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);

        // Manual adjacencies put into manual map
        adjacencyList.put(node1, node1Adjacencies);
        adjacencyList.put(node2, node2Adjacencies);
        adjacencyList.put(node3, node3Adjacencies);


        graph = new SimpleGraph<>(edges);

        // Construct directed graph

        directedEdges = new HashSet<>();

        directedAdjacencyList = new HashMap<>();

        directedNodes = new HashSet<>();
        directedNodes.add(node1);
        directedNodes.add(node2);
        directedNodes.add(node3);
        directedNodes.add(node4);

        directedNode1Adjacencies = new HashSet<>();
        directedNode1Neighbors = new HashSet<>();
        directedNode2Adjacencies = new HashSet<>();
        directedNode2Neighbors = new HashSet<>();
        directedNode3Adjacencies = new HashSet<>();
        directedNode3Neighbors = new HashSet<>();
        directedNode4Adjacencies = new HashSet<>();
        directedNode4Neighbors = new HashSet<>();

        Edge<Integer> directedEdge1 = new Edge(1,2,true);
        directedNode1Adjacencies.add(directedEdge1);
        directedNode1Neighbors.add(node2);
        Edge<Integer> directedEdge2 = new Edge(2,1,true);
        directedNode2Adjacencies.add(directedEdge2);
        directedNode2Neighbors.add(node1);
        Edge<Integer> directedEdge3 = new Edge(3,1,true);
        directedNode3Adjacencies.add(directedEdge3);
        directedNode3Neighbors.add(node1);
        Edge<Integer> directedEdge4 = new Edge(4,1,true);
        directedNode4Adjacencies.add(directedEdge4);
        directedNode4Neighbors.add(node1);

        directedEdges.add(directedEdge1);
        directedEdges.add(directedEdge2);
        directedEdges.add(directedEdge3);
        directedEdges.add(directedEdge4);

        directedAdjacencyList.put(node1, directedNode1Adjacencies);
        directedAdjacencyList.put(node2, directedNode2Adjacencies);
        directedAdjacencyList.put(node3, directedNode3Adjacencies);
        directedAdjacencyList.put(node4, directedNode4Adjacencies);

        directedGraph = new SimpleGraph<>(directedEdges);
    }

    @Test
    @DisplayName("Undirected graph detects it is undirected")
    void isUndirectedUndirected(){
        assertFalse(graph.isDirected());
    }

    @Test
    @DisplayName("Directed graph detects it is Directed")
    void isDirectedDirected(){
        assertTrue(directedGraph.isDirected());
    }


    @Test
    @DisplayName("Neighbors returns the correct neighbors in undirected graph")
    void neighborsUndirected(){
        assertEquals(node1Neighbors, graph.neighbors(node1));
        assertEquals(node2Neighbors, graph.neighbors(node2));
        assertEquals(node3Neighbors, graph.neighbors(node3));
    }

    @Test
    @DisplayName("Neighbors returns the correct neighbors in directed graph")
    void neighborsDirected(){
        assertEquals(directedNode1Neighbors, directedGraph.neighbors(node1));
        assertEquals(directedNode2Neighbors, directedGraph.neighbors(node2));
        assertEquals(directedNode3Neighbors, directedGraph.neighbors(node3));
        assertEquals(directedNode4Neighbors, directedGraph.neighbors(node4));
    }

    @Test
    @DisplayName("Edges return appropriately")
    void edgesReturn(){
        assertEquals(edges, graph.getEdges());
        assertEquals(directedEdges, directedGraph.getEdges());
    }

    @Test
    @DisplayName("Nodes return appropriately")
    void nodesReturn(){
        assertEquals(nodes, graph.getNodes());
        assertEquals(directedNodes, directedGraph.getNodes());
    }

    @Test
    @DisplayName("Edge is added correctly to undirected graph")
    void addEdgeToUndirectedGraph(){
        Edge<Integer> edge = new Edge(3,2);
        edges.add(edge);
        node3Adjacencies.add(edge);
        node2Adjacencies.add(edge);
        node3Neighbors.add(node2);
        node2Neighbors.add(node3);

        graph.addEdge(edge);

        assertEquals(node3Neighbors, graph.neighbors(node3));
        assertEquals(node2Neighbors, graph.neighbors(node2));
        assertEquals(edges, graph.getEdges());
    }

    @Test
    @DisplayName("Edge is added correctly to directed graph")
    void addEdgeToDirectedGraph(){
        Edge<Integer> edge = new Edge(3,2);
        directedEdges.add(edge);
        directedNode3Adjacencies.add(edge);
        directedNode3Neighbors.add(node2);

        directedGraph.addEdge(edge);

        assertEquals(directedNode3Neighbors, directedGraph.neighbors(node3));
        assertEquals(directedNode2Neighbors, directedGraph.neighbors(node2));
        assertEquals(directedEdges, directedGraph.getEdges());
    }

    @Test
    @DisplayName("Edge is correctly removed to undirected graph")
    void removeEdgeFromUndirectedGraph(){
        Edge<Integer> edge = new Edge<>(1,2); // This edge is in the graph
        Edge<Integer> edgeN = new Edge<>(6,7); // This edge is NOT in the graph

        edges.remove(edge);
        node1Adjacencies.remove(edge);
        node2Adjacencies.remove(edge);
        node1Neighbors.remove(node2);
        node2Neighbors.remove(node1);

        assertTrue(graph.removeEdge(edge));
        assertFalse(graph.removeEdge(edgeN));

        assertEquals(node1Neighbors, graph.neighbors(node1));
        assertEquals(node2Neighbors, graph.neighbors(node2));
        assertEquals(edges, graph.getEdges());
    }

    @Test
    @DisplayName("Edge is correctly removed to directed graph")
    void removeEdgeFromDirectedGraph(){
        Edge<Integer> edge = new Edge<>(1,2,true); // This edge is in the graph
        Edge<Integer> edgeN = new Edge<>(6,7,true); // This edge is NOT in the graph

        directedEdges.remove(edge);
        directedNode1Adjacencies.remove(edge);
        directedNode1Neighbors.remove(node2);

        assertTrue(directedGraph.removeEdge(edge));
        assertFalse(directedGraph.removeEdge(edgeN));

        assertEquals(directedNode1Neighbors, directedGraph.neighbors(node1));
        assertEquals(directedNode2Neighbors, directedGraph.neighbors(node2));
        assertEquals(directedEdges, directedGraph.getEdges());
    }

    @Test
    @DisplayName("Contains node works")
    void containsNodeWorks(){
        assertTrue(graph.containsNode(node1));
        assertTrue(directedGraph.containsNode(node1));
        assertFalse(graph.containsNode(node4));
        assertTrue(directedGraph.containsNode(node4));
    }

    @Test
    @DisplayName("Contains edge works")
    void containsEdgeWorks(){
        Edge<Integer> edge = new Edge<>(1,2); // This edge is in the graph
        Edge<Integer> edgeN = new Edge<>(6,7); // This edge is NOT in the graph

        Edge<Integer> directedEdge = new Edge<>(1,2,true); // This edge is in the directed graph
        Edge<Integer> directedEdgeN = new Edge<>(6,7,true); // This edge is NOT in the directed graph

        assertTrue(graph.containsEdge(edge));
        assertFalse(graph.containsEdge(edgeN));

        assertTrue(directedGraph.containsEdge(directedEdge));
        assertFalse(directedGraph.containsEdge(directedEdgeN));
    }

    @Test
    @DisplayName("Contains works")
    void containsWorks(){
        Edge<Integer> edge = new Edge<>(1,2); // This edge is in the graph
        Edge<Integer> edgeN = new Edge<>(6,7); // This edge is NOT in the graph
        Edge<String> edgeNT = new Edge<>("bingus","jingus"); // This edge is NOT even the type of the graph

        Edge<Integer> directedEdge = new Edge<>(1,2,true); // This edge is in the directed graph
        Edge<Integer> directedEdgeN = new Edge<>(6,7,true); // This edge is NOT in the directed graph

        assertTrue(graph.contains(node1));
        assertFalse(graph.contains(new Node<String>("String"))); // Node is not even correct type
        assertTrue(directedGraph.contains(node1));

        assertFalse(graph.contains(node4));
        assertTrue(directedGraph.contains(node4));

        assertTrue(graph.contains(edge));
        assertFalse(graph.contains(edgeN));
        assertFalse(graph.contains(edgeNT));

        assertTrue(directedGraph.contains(directedEdge));
        assertFalse(directedGraph.contains(directedEdgeN));
    }

}
