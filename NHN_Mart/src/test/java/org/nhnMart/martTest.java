package org.nhnMart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class martTest
{

    @Test
    @DisplayName("마트 객체 정상 테스트 ")
    public void martCreateTest() {
        Mart m = new Mart();
        Assertions.assertNotNull(m);
    }

    @Test
    @DisplayName("마트 판매 기능 테스트 ")
    public void martSellTest() {
        Mart m = new Mart();

        int testOutput = m.isSell("양파",1);
        Assertions.assertEquals(1000, testOutput);
    }

    @Test
    @DisplayName("마트에 물건이 없을 경우 테스트 ")
    public void martSellExceptionTest() {
        Mart m = new Mart();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> m.isSell("우유", 500)); // 예상되는 예외를 받는지 확인
    }

    @Test
    @DisplayName("마트에 재고가 부족할 경우 테스트 ")
    public void martItemEmptyTest() {
        Mart m = new Mart();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> m.isSell("계란", 10)); // 예상되는 예외를 받는지 확인
    }
}
