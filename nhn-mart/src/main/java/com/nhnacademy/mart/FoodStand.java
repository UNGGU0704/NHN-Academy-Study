package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현
    public void add(Food a) {
        foods.add(a);
    }

    public Food get(int index) {
        if (foods.size() == 0 ){
           throw new ArrayIndexOutOfBoundsException("푸드리스트가 비었어요.");
        }
        return foods.get(index);
    }

    public int size(){
        return foods.size();
    }


    // TODO 장바구니에 담은 Food 삭제 구현
    public void delete(int index){
        if (foods.size() == 0 ){
            throw new ArrayIndexOutOfBoundsException(" 비었어요.");
        }
        foods.remove(index);
    }
}
