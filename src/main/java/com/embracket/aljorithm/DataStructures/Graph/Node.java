package com.embracket.aljorithm.DataStructures.Graph;

import java.util.Objects;

public class Node<T> {
    private T content;

    public Node(T content){this.content = content;}

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Node<T> node = (Node<T>) obj;
        return Objects.equals(content, node.getContent());
        // A node with the same content is considered equal
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "(" + content.toString() + ")";
    }
}
