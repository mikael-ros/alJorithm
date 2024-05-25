package com.embracket.aljorithm.DataStructures.Util;

import java.util.Objects;

public class Pair<T> {
    private static int ID = 0;
    private final int id;
    private final T first;
    private final T second;

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
        id = ID++;
    }

    public T fst(){
        return first;
    }

    public T snd(){
        return second;
    }

    public T other(T member){
        return member.equals(first) ? second : first;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first,second,id);
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Pair<T> pair = (Pair<T>) obj;
        return      Objects.equals(fst(), pair.fst())
                &&  Objects.equals(snd(), pair.snd());
        // An edge with the same nodes and direction status is considered equal
    }
}
