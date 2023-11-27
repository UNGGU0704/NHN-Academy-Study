package com.tip.functional;

public interface InfiniteIterator<T> extends java.util.Iterator<T> {



    public T next();
    default boolean hasNext(){
        return true;
    }
}
