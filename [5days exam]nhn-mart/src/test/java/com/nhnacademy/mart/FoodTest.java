package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FoodTest {

    @Test
    @DisplayName("가격이 음수 셋팅")
    public void minusPrice() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Food("우유", -1));
    }

    @Test
    @DisplayName("푸드 객체 및 푸드 스탠드 생성 테스트 ")
    public void FoodCreateTest() {
        Food food = new Food("사과", 400);
        FoodStand foodStand = new FoodStand();
        foodStand.add(food);

        Assertions.assertEquals("사과", foodStand.get(0).getName());
    }

    @Test
    @DisplayName("푸드 스탠드 생성 테스트 ")
    public void FoodStandCreateTest() {
        FoodStand f = new FoodStand();

        Assertions.assertNotNull(f);
    }

    @Test
    @DisplayName("빈 푸드 스탠드 get 테스트 ")
    public void FoodStandGetTest() {
        FoodStand foodStand = new FoodStand();

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> foodStand.get(2)); // 예상되는 예외를 받는지 확인
    }

    @Test
    @DisplayName("빈 푸드 스탠드 delete 테스트 ")
    public void FoodStandDeleteTest() {
        FoodStand foodStand = new FoodStand();


        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> foodStand.delete(2)); // 예상되는 예외를 받는지 확인
    }

}
