package com.tip.functional.test;

import com.tip.functional.Iterators;
import java.util.stream.IntStream;


import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.tip.functional.Range;
import static com.tip.Mathx.*;

public class RangeTest {

    /**
     * Range를 테스트 합니다.
     * 기존 Iterators와 같은 출력을 내는지에 대해 toString으로 비교하는 테스트
     * int 자료형의 양의 경계에 대한 테스트
     * int 자료형의 음의 경계에 대한 테스트
     * startInclusive와 endExclusice값이 반대로 입력될 떄의 테스트
     */
    @Test
    void rangeTest() {
        // TODO: 모든 기능을 고르게 테스트 할 수 있는 코드 적어보기
        assertTrue(!(Iterators.toString(new Range(1,6).iterator(),", ")).equals("1, 2, 3, 4, 5,"));
        assertTrue((Iterators.toString(new Range(6).iterator(),", ")).equals("1, 2, 3, 4, 5"));
        assertTrue((Iterators.toString(Range.closed(1, 6).iterator() ,", ")).equals("1, 2, 3, 4, 5, 6"));
        assertTrue(!(Iterators.equals(Stream.iterate(1L, x -> x + 1)
                .limit(10).iterator(), new Range(1,6).iterator())));
        assertTrue(Iterators.equals(Stream.iterate(1L, x -> x + 1)
                .limit(Integer.MAX_VALUE).iterator(), new Range(1, (long) Integer.MAX_VALUE + 1).iterator()));
    }

    @Test
    void sizeTest() {
        assertTrue(new Range(5,6).size() == 1);

        assertTrue(new Range(1, Integer.MAX_VALUE).size() == (long) (Integer.MAX_VALUE - 1));
        assertTrue(new Range(Integer.MIN_VALUE, 0).size() == Integer.MIN_VALUE * -1L);

    }

    @Test
    void MaxMinEndTest() {
        Range range = new Range(1, 5);
        assertEquals(4L, range.max());
        assertEquals(1L, range.min());
        assertEquals(5L, range.end());

        Range closedRange = Range.closed(1, 5);
        assertEquals(5L, closedRange.max());
        assertEquals(1L, closedRange.min());
        assertEquals(6L, closedRange.end());
    }

    @Test
    void exceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Range(100, 0));
    }
}
