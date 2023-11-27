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
                try {
                        Iterators.equals(null, Stream.iterate(5, x -> x * 2).limit(10).iterator());
                        Iterators.equals(Stream.iterate(5, x -> x * 2).limit(10).iterator(), null);
                        fail("예외가 발생하지 않음");
                } catch (NullPointerException e) {}
        }

        /**
         * iterator에 대한 toString() 테스트
         * separator 가 "", " " , "," 일 경우를 테스트
         * 빈 iterator일 경우 테스트
         * 무한 iterator일 경우 테스트
         * null 일경우 Exception 테스트
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

                try {
                        Iterators.toString(null, ",");
                        fail("예외가 발생하지 않음");
                } catch (NullPointerException e) {}
        }

        /**
         * limit 테스트
         * maxSize에 음수가 들어갈 경우 테스트
         * maxSize에 int 최댓값이 들어갈 경우 테스트
         */
        @Test
        public void limitTest() {
                assertEquals(Iterators.toString(limit(iterate(0, x -> x + 1), 10), ""),
                        Stream.iterate(0, x -> x + 1).limit(10).map(String::valueOf)
                                .collect(Collectors.joining("")));

                assertThrows(IllegalArgumentException.class, () -> Iterators.limit(iterate(0, x -> x + 1), -5));
                assertEquals(Iterators.count(limit(iterate(0, x -> x + 1), Integer.MAX_VALUE)), Integer.MAX_VALUE);
                try {
                        Iterators.limit(null, 100).next();
                        fail("예외가 발생하지 않음");
                } catch (NullPointerException e) {}
        }


        /**
         * iterateTest 테스트
         *
         * 디폴트 UnaryOperator가 적용되는지 테스트
         * InfiniteIterator가 생성되는지 테스트
         */
        @Test
        public void iterateTest() {
                assertTrue(iterate(1, x -> x + 1) instanceof InfiniteIterator);
                assertTrue(!(limit(iterate(1, x -> x + 1), 10) instanceof InfiniteIterator));

                InfiniteIterator<Integer> infiniteIterator =  Iterators.iterate(1, null);

                System.out.println(Iterators.iterate(1, null).next());
                System.out.println(Iterators.iterate(1, null).next());
        }

        /**
         * filter 테스트
         * hasNext() 하면서 next()가 되서 다음 인자로 가버리는 버그를 수정
         * fillter를 테스트 하다가 더이상 찾을 요소가 없을 경우 exception을 던지는 테스트
         * 무한 반복자 일 경우에 throw를 던지는지 테스트
         * int의 경계 값에 대해서도 적절한 filter가 적용되는지 테스트
         * Predicate가 null 일 경우에는 디폴트 Predicate가 들어가는지 테스트
         * Iterator가 null 일경우에는 Exception을 던지는지 테스트
         */
        @Test
        void filterTest() {
                assertTrue(fibonacci() instanceof InfiniteIterator);
                Iterable<Integer> fib = Mathx::fibonacci;
                assertTrue(Iterators.equals(limit(fibonacci(), 10), StreamSupport
                                .stream(fib.spliterator(), false).limit(10).iterator()));

                // int 경계 filter 테스트 -> 너무 오래걸림...
//                assertEquals(Iterators.count(limit(filter(iterate(0, x -> x + 1), x -> x / 2 == 0), Integer.MAX_VALUE)),
//                        Integer.MAX_VALUE / 2);

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

                Iterator<Integer> predicateNullIterator = Iterators.filter(Arrays.asList(1,2,3,4).iterator(), null);
                assertEquals(1, predicateNullIterator.next());
                assertEquals(2, predicateNullIterator.next());
                assertEquals(3, predicateNullIterator.next());

                try {
                        Iterators.filter(null, (x) -> true).next();
                        fail("예외가 발생하지 않음");
                } catch (NullPointerException e) {}


        }

        /**
         * 반복자의 요소의 갯수를 샙니다.
         *
         * 무한 반복자가 들어올시에 throw하는 테스트
         * null 이 들어올시에 적절한 Exception을 던지는 테스트
         * int 경계값을 세는 테스트
         */
        @Test
        void countTest() {
                assertEquals(Iterators.count(limit(iterate(1, x -> x+1), 100)),100);
                assertEquals(Iterators.count(limit(iterate(0, x -> x+1), 0)),0);
                assertEquals(Iterators.count(limit(iterate(0, x -> x+1), Integer.MAX_VALUE)),Integer.MAX_VALUE);

                assertThrows(IllegalArgumentException.class, () -> Iterators.count(Iterators.iterate(1, x -> x + 1)));
                try {
                        Iterators.count(null);
                } catch (NullPointerException e) {}
        }


}
