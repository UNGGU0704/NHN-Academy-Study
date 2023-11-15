package com.tip.functional;

public interface InfiniteIterator<T> extends java.util.Iterator<T> {
    // TODO: 채우기
    public T next();
    default boolean hasNext(){
        return true;
    }
}
