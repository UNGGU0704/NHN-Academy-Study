package org.nhnmart;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mart is contained Items in HashMap.
 *
 *
 * @author KIM KYU HYEONG
 *
 */

public class Mart {
    private static final Logger logger = LoggerFactory.getLogger(Mart.class);
    HashMap<String, Integer> itemList;
    HashMap<String, Integer> itemCount;

    Mart() {
        itemList = new HashMap<>();
        itemCount = new HashMap<>();

        itemList.put("양파", 1000);
        itemList.put("계란", 5000);
        itemList.put("파", 500);
        itemList.put("사과", 2000);

        itemCount.put("양파", 2);
        itemCount.put("계란", 5);
        itemCount.put("파", 10);
        itemCount.put("사과", 20);

    }

    /**
     * is sell is selling Item.
     *
     *
     * @param item is Item Name 
     * @param  count is Item count
     */
    public int isSell(String item, int count) {
        if (!itemList.containsKey(item)) {
            logger.warn("마트에 없는 상품을 요청했습니다.");
            throw new IllegalArgumentException("마트에 없는 상품입니다.");
        }
        if (itemCount.get(item) < count) {
            logger.warn("재고가 부족한 물건을 요청했습니다.");
            throw new IllegalArgumentException("재고가 부족해서 구매할 수 없습니다.");
        } else {

            int newCount = itemCount.get(item) - count;
            itemCount.put(item, newCount);
        } // 재고 소모 처리

        int price = itemList.get(item) * count; // 가격 계산
        logger.info("{} 원 어치의 물건의 가격", price);
        return price;
    }
}
