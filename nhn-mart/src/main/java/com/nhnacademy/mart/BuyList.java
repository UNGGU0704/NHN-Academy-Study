package com.nhnacademy.mart;

import java.util.ArrayList;

public class BuyList {

    private final ArrayList<Item> items = new ArrayList<>();

    // TODO add 메서드 생성
    public void add(String n, int a){
        Item i = new Item(n,a);
        items.add(i);
    }

    public String getName(int index){
        if (items.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("구매 리스트가 비어있습니다.");
        }
        return items.get(index).name;
    }

    public int getAmount(int index){
        if (items.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("구매 리스트가 비어있습니다.");
        }
        return items.get(index).amount;
    }

    public int size(){
        return items.size();
    }


    public static class Item {
        private final String name;
        private final int amount;

        Item(String s , int a){
            if(a < 0) {
                throw new IllegalArgumentException("음수는 살수 없습니다.");
            }
            this.name = s;
            this.amount = a;
        }


    }
}
