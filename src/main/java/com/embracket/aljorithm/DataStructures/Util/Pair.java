package com.embracket.aljorithm.DataStructures.Util;

public class Pair<T> {
    private final T first;
    private final T second;

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T fst(){
        return first;
    }

    public T snd(){
        return second;
    }
}
