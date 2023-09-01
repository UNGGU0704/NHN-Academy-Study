package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    @DisplayName("바스켓 리스트가 빌 경우 테스트 ")
    public void emptyBasket() {
        Basket basket = new Basket();
        Food food = new Food("초밥",3000);

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> basket.get(0));
    }
}
