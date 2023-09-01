package com.nhnacademy.mart;

public class Food {

    private final String name;
    private final int price;

    public Food(String n, int p){
        if(p < 0) throw new IllegalArgumentException("가격은 음수가 될 수 없습니다;.");
        this.name = n;
        this.price = p;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
