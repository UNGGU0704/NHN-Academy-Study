package com.nhnacademy.mart;

import java.util.ArrayList;

public class Basket {
    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food food) {
        foods.add(food);
    }

    public Food get(int index) {
        if(foods.size() <= 0) throw new ArrayIndexOutOfBoundsException("Foods가 비었습니다.");
        return foods.get(index);
    }

    public int size(){
        return foods.size();
    }
}
