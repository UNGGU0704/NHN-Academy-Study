package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class nhnMartTest {

    @Test
    @DisplayName("마트 생성 정상 테스트 ")
    public void martCreateTest() {
        NhnMart m = new NhnMart();

        Assertions.assertNotNull(m);
    }

    @Test
    @DisplayName("FoodStand 갯수  테스트")
    public void createFoodStand() {
        NhnMart nhnMart = new NhnMart();
        nhnMart.prepareMart();

        Assertions.assertEquals(nhnMart.getFoodStand().size(), 37); // 37 : 생성 테스트
    }


}
