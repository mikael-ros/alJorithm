package com.embracket.aljorithm.DataStructures.Graph;

public interface AbstractEdge<T> {
    Node<T> from();

    Node<T> to();

    Node<T> otherEnd(Node<T> oneEnd);
}
