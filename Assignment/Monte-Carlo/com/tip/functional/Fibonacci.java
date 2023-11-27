package com.tip.functional;

public class Fibonacci implements InfiniteIterator<Integer> {
    // TODO: 채우기
    private int prev = 0;
    private int curr = 1;

    @Override
    public Integer next() {
        int next = prev + curr;
        prev = curr;
        curr = next;
        return next;
    }
    // 1

}
