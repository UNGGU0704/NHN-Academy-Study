package com.tip.functional.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.tip.Mathx;
import com.tip.functional.*;
import static com.tip.functional.Iterators.*;
import static com.tip.Mathx.*;

public class IteratorsTest {

        /**
         * iterate에 대한 equals 테스트
         *
         * 정상적인 equlas 테스트
         * 요소는 같지만 순서는 다른 경우 테스트
         * 빈 iterator에 대한 테스트
         * 무한 iterator에 대한 테스트
         */
        @Test
        public void equalsTest() {
                assertTrue(!Iterators.equals(limit(iterate(1, x -> x + 1), 10),
                        Stream.iterate(1, x -> x + 1).limit(5).iterator()));
                assertTrue(Iterators.equals(limit(iterate(1, x -> x + 1), 10),
                        Stream.iterate(1, x -> x + 1).limit(10).iterator()));
                assertTrue(!(Iterators.equals(Iterators.limit(iterate(1, x -> x + 2), 3),
                        Arrays.asList(1,5,3).iterator())));
                assertTrue(Iterators.equals(limit(iterate(1, x -> x + 1), 0),
                        Stream.iterate(1, x -> x + 1).limit(0).iterator()));
                assertThrows(IllegalArgumentException.class, () -> Iterators.equals(Iterators.iterate(2, x -> x * x),
                        Iterators.limit(Iterators.iterate(2, x -> x * x), 10)));
        }

        /**
         * iterator에 대한 toString() 테스트
         * separator 가 "", " " , "," 일 경우를 테스트
         * 빈 iterator일 경우 테스트
         * 무한 iterator일 경우 테스트
         */
        @Test
        public void toStringTest() {
                assertEquals(Iterators.toString(limit(iterate(1, x -> x + 1), 10), " "),
                        Stream.iterate(1, x -> x + 1).limit(10).map(String::valueOf)
                                .reduce((x, y) -> x + " " + y).orElse(""));
                assertEquals(Iterators.toString(limit(iterate(1, x -> x + 1), 10), ""),
                        Stream.iterate(1, x -> x + 1).limit(10).map(String::valueOf)
                                .reduce((x, y) -> x + "" + y).orElse(""));
                assertEquals(Iterators.toString(limit(iterate(1, x -> x + 1), 10), ","),
                        Stream.iterate(1, x -> x + 1).limit(10).map(String::valueOf)
                                .collect(Collectors.joining(",")));
                assertEquals(Iterators.toString(limit(iterate(-1, x -> x + 1), 5), ","),
                        Stream.iterate(-1, x -> x + 1).limit(5).map(String::valueOf)
                                .collect(Collectors.joining(",")));
                assertEquals(Iterators.toString(limit(iterate(1, x -> x + 1), 1), ","),
                        Stream.iterate(1, x -> x + 1).limit(1).map(String::valueOf)
                                .collect(Collectors.joining(",")));
                assertEquals(Iterators.toString(limit(iterate(1, x -> x + 1), 0), ","),
                        Stream.iterate(1, x -> x + 1).limit(0).map(String::valueOf)
                                .collect(Collectors.joining(",")));
                assertThrows(IllegalArgumentException.class, () -> Iterators.toString(Iterators.iterate(2, x -> x * x), " "));
        }


        @Test
        public void iterateTest() {
                assertTrue(iterate(1, x -> x + 1) instanceof InfiniteIterator);
                assertTrue(!(limit(iterate(1, x -> x + 1), 10) instanceof InfiniteIterator));

        }

        /**
         * filter 테스트
         * hasNext() 하면서 next()가 되서 다음 인자로 가버리는 버그를 수정
         *
         */
        @Test
        void filterTest() {
                assertTrue(fibonacci() instanceof InfiniteIterator);
                Iterable<Integer> fib = Mathx::fibonacci;
                assertTrue(Iterators.equals(limit(fibonacci(), 10), StreamSupport
                                .stream(fib.spliterator(), false).limit(10).iterator()));

                Iterator<Integer> oddIterator = Iterators.filter(Arrays.asList(1,2,3,4,5,6,7,8,10,12,13).iterator(),
                                                                (num) -> num % 2 == 1);

                assertTrue(oddIterator.hasNext() && (oddIterator.next() == 1));
                assertTrue(oddIterator.hasNext() && (oddIterator.next() == 3));
                assertTrue(oddIterator.hasNext() && (oddIterator.next() == 5));
                assertTrue(oddIterator.hasNext() && (oddIterator.next() == 7));
                assertEquals(13, oddIterator.next());
                assertThrows(NoSuchElementException.class, oddIterator::next);

                Iterator<Integer> onlyOneIterator = Iterators.filter(Arrays.asList(2,3,4,5,6,7,8,10,12,13).iterator(),
                        (num) -> num  == 1);
                assertThrows(NoSuchElementException.class, onlyOneIterator::next);

                Iterators.filter(Iterators.iterate(1, x -> x + 1), (x) -> true);
        }

        @Test
        void countTest() {
                assertEquals(Iterators.count(limit(iterate(1, x -> x+1), 100)),100);
                assertEquals(Iterators.count(limit(iterate(0, x -> x+1), 0)),0);

                assertThrows(IllegalArgumentException.class, () -> Iterators.count(Iterators.iterate(1, x -> x + 1)));
        }


}
