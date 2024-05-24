package com.embracket.aljorithm.Graph;

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
        return obj instanceof Node<?> other
                && other.getContent().equals(content);
        // A node with the same content is considered equal
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
