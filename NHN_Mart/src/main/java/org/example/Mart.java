package org.example;

import java.util.*;

public class Mart {
    HashMap<String, Integer> itemList;
    HashMap<String, Integer> itemLCount;

    Mart() {
        itemList = new HashMap<>();
        itemLCount = new HashMap<>();

        itemList.put("양파", 1000);
        itemList.put("계란", 5000);
        itemList.put("파", 500);
        itemList.put("사과", 2000);

        itemLCount.put("양파", 2);
        itemLCount.put("계란", 5);
        itemLCount.put("파", 10);
        itemLCount.put("사과", 20);

    }

    public int isSell(String item, int count){
        if (!itemList.containsKey(item)) {
            throw new IllegalArgumentException("마트에 없는 상품입니다.");
        }
        if (itemLCount.get(item) < count) {
            throw new IllegalArgumentException("재고가 부족해서 구매할 수 없습니다.");
        } else {
            int newCount = itemLCount.get(item) - count;
            itemLCount.put(item,newCount);
        } // 재고 소모 처리

        int price = itemList.get(item) * count; // 가격 계산

        return price;
    }
}
