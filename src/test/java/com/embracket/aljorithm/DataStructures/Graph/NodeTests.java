package com.embracket.aljorithm.DataStructures.Graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

public class NodeTests {
    Node<String> node1;
    Node<String> node2;
    final String element = "content";
    final String element2 = "content2";
    @BeforeEach
    void setUp() {
        node1 = new Node(element);
        node2 = new Node(element2);
    }

    @Test
    @DisplayName("Content is reachable")
    void contentReturns(){
        assertEquals(element, node1.getContent());
    }

    @Test
    @DisplayName("Changing content works")
    void setContentWorks(){
        assertEquals(element, node1.getContent());
        node1.setContent("test");
        assertEquals("test", node1.getContent());
        node1.setContent("test2");
        assertEquals("test2", node1.getContent());
    }

    @Test
    @DisplayName("Node can act as a key, or be put in a set")
    void nodeUnique(){
        Set<Node> set = new HashSet<>();
        set.add(node1);
        set.add(node2);
        assertEquals(2,set.size());

        set.add(node1);
        set.add(node2);
        assertEquals(2,set.size()); // Should still be 2
    }

    @Test
    @DisplayName("Print looks like (content)")
    void toStringLayoutCorrect(){
        assertEquals("(content)", node1.toString());
    }

    @Test
    @DisplayName("Node can be compared with equals")
    void equalsWorks(){
        assertEquals(false, node1.equals(node2));
        assertEquals(true, node2.equals(node2));
        assertEquals(false, node2.equals("content2")); // A node compared to something that isn't a node should return false
    }
}
