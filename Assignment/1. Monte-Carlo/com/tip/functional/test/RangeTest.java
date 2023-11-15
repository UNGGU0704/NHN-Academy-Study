package com.tip.functional.test;

import com.tip.functional.Iterators;
import java.util.stream.IntStream;


import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.tip.functional.Range;
import static com.tip.Mathx.*;

public class RangeTest {
    @Test
    public void rangeTest() {
        // TODO: 모든 기능을 고르게 테스트 할 수 있는 코드 적어보기
        assertTrue(!(Iterators.toString(new Range(1,6).iterator(),", ")).equals("1, 2, 3, 4, 5,"));
        assertTrue((Iterators.toString(new Range(-1,3).iterator(),", ")).equals("-1, 0, 1, 2, 3"));
        assertTrue(!(Iterators.equals(Stream.iterate(Long.valueOf(1), x -> x + 1)
                .limit(10).iterator(), new Range(1,6).iterator())));
        assertTrue(Iterators.equals(Stream.iterate(Long.valueOf(1), x -> x + 1)
                .limit(Integer.MAX_VALUE).iterator(), new Range(1, Integer.MAX_VALUE).iterator()));

        assertTrue(new Range(Integer.MIN_VALUE, 1).size() == (long) Math.abs(Integer.MIN_VALUE) + 1);
    }
}
