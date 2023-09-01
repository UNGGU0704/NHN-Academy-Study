package org.nhnMart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class customerTest {

    @Test
    @DisplayName("손님 객체 생성 테스트 ")
    public void customerCreateTest() {
        Customer c = new Customer(500);
        Assertions.assertNotNull(c);
    }

    @Test
    @DisplayName("손님의 구매 테스트 ")
    public void customerBuyTest() {
        Customer c = new Customer(10000);
        c.isBuy(5000);

        Assertions.assertEquals(5000,c.getMoney());
    }

    @Test
    @DisplayName("손님의 돈이 부족할 경우 테스트 ")
    public void customerBuyExceptionTest() {
        Customer c = new Customer(500);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> c.isBuy(5000)); // 예상되는 예외를 받는지 확인
    }

}
