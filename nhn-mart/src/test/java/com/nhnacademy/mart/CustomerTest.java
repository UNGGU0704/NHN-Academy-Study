package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {


    @Test
    @DisplayName("Coustomer 객체 생성시 buyList null 테스트 ")
    public void createCustomer() {
        Customer c = new Customer(null);
        Assertions.assertNull(new Customer(null));
    }

    @Test
    @DisplayName("FoodStand에서 찾을 수 없는 테스트  ")
    public void noItemTest() {
        BuyList buyList = new BuyList();
        buyList.add("우유", 5000);

        Customer c = new Customer(buyList);
        Basket b = new Basket();
        c.bring(b);

        Food food = new Food("사과",400);
        FoodStand foodStand = new FoodStand();
        foodStand.add(food);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> c.pickFoods(foodStand));
    }

}
