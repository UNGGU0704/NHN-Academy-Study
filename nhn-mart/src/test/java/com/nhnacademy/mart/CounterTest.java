package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CounterTest {

    @Test
    @DisplayName("구매할떄 바스켓에 null 테스트 ")
    public void nullbasket() {
        Counter c = new Counter();
        Assertions.assertThrows(NullPointerException.class, () -> c.pay(null));
    }

    @Test
    @DisplayName("구매할떄 바스켓이 비었는 테스트 ")
    public void emptyBasket() {
        Counter c = new Counter();
        Basket b = new Basket();
        Assertions.assertThrows(Error.class, () -> c.pay(b));
    }

    @Test
    @DisplayName("돈이 부족할 경우 테스트")
    public void leakMoney() {
        Food expensiveFood = new Food("비싼 음식", 100000);
        Basket basket = new Basket();
        basket.add(expensiveFood);

        Counter counter = new Counter();

        Assertions.assertThrows(Error.class, () -> counter.pay(basket));
    }
}
