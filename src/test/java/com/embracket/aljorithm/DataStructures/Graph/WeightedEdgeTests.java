package com.embracket.aljorithm.DataStructures.Graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class WeightedEdgeTests {
    Node<String> node1;
    Node<String> node2;
    final String element = "content";
    final String element2 = "content2";

    WeightedEdge<String> edge1;
    WeightedEdge<String> edge2;

    @BeforeEach
    void setUp() {
        node1 = new Node(element);
        node2 = new Node(element2);

        edge1 = new WeightedEdge<>(node1,node2,2);
        edge2 = new WeightedEdge<>(node2,node1, 3, true);
    }

    @Test
    @DisplayName("Shorthand constructors work")
    void shorthandWeightedEdgeWorks(){
        WeightedEdge<String> shortHandEdge1 = new WeightedEdge(element, element2,2);
        assertEquals(node1, shortHandEdge1.from());
        assertEquals(node2, shortHandEdge1.to());
        assertEquals(2.0, shortHandEdge1.getWeight(),0);

        WeightedEdge<String> shortHandEdge2 = new WeightedEdge(element2, element,3, true);
        assertEquals(node2, shortHandEdge2.from());
        assertEquals(node1, shortHandEdge2.to());
        assertEquals(3.0, shortHandEdge2.getWeight(),0);
    }

    @Test
    @DisplayName("Edge can act as a key, or be put in a set")
    void weightedEdgeUnique(){
        Set<WeightedEdge> set = new HashSet<>();
        set.add(edge1);
        set.add(edge2);
        assertEquals(2,set.size());

        set.add(edge1);
        set.add(edge2);
        assertEquals(2,set.size()); // Should still be 2
    }

    @Test
    @DisplayName("Print looks like (content) <---> (content2) [Weight = x.x] or similar")
    void toStringLayoutCorrect(){
        assertEquals("(content) <---> (content2) [Weight = 2.0]", edge1.toString());
        assertEquals("(content2) ---> (content) [Weight = 3.0]", edge2.toString());
    }

    @Test
    @DisplayName("Edge can be compared with equals")
    void weightedEdgeEqualsWorks(){
        assertEquals(true, edge1.equals(edge1));
        assertEquals(false, edge2.equals(edge1));
        assertEquals(false, edge1.equals(node1)); // An edge compared to something that isn't a edge should return false
    }
}
