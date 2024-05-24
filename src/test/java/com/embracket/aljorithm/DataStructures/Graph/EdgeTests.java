package com.embracket.aljorithm.DataStructures.Graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

public class EdgeTests {
    Node<String> node1;
    Node<String> node2;
    final String element = "content";
    final String element2 = "content2";

    Edge<String> edge1;
    Edge<String> edge2;

    @BeforeEach
    void setUp() {
        node1 = new Node(element);
        node2 = new Node(element2);

        edge1 = new Edge<>(node1,node2);
        edge2 = new Edge<>(node2,node1,true);
    }

    @Test
    @DisplayName("Adjacent end works")
    void otherEndWorks(){
        assertEquals(node1, edge1.otherEnd(node2));
        assertEquals(node2, edge1.otherEnd(node1));
    }

    @Test
    @DisplayName("Shorthand constructors work")
    void shorthandEdgeWorks(){
        Edge<String> shortHandEdge1 = new Edge(element, element2);
        assertEquals(node1, shortHandEdge1.from());
        assertEquals(node2, shortHandEdge1.to());

        Edge<String> shortHandEdge2 = new Edge(element2, element, true);
        assertEquals(node2, shortHandEdge2.from());
        assertEquals(node1, shortHandEdge2.to());
    }

    @Test
    @DisplayName("Edge can act as a key, or be put in a set")
    void edgeUnique(){
        Set<Edge> set = new HashSet<>();
        set.add(edge1);
        set.add(edge2);
        assertEquals(2,set.size());

        set.add(edge1);
        set.add(edge2);
        assertEquals(2,set.size()); // Should still be 2
    }

    @Test
    @DisplayName("Print looks like (content) <---> (content2) or similar")
    void toStringLayoutCorrect(){
        assertEquals("(content) <---> (content2)", edge1.toString());
        assertEquals("(content2) ---> (content)", edge2.toString());
    }

    @Test
    @DisplayName("Edge can be compared with equals")
    void equalsWorks(){
        assertEquals(true, edge1.equals(edge1));
        assertEquals(false, edge2.equals(edge1));
        assertEquals(false, edge1.equals(node1)); // An edge compared to something that isn't a edge should return false
    }
}
