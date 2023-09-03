package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * buyList is whishList of Customer.
 *
 * @author kIm kyu hyeong
 */
public class BuyList {

    private final ArrayList<Item> items = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

    // TODO add 메서드 생성
    public void add(String n, int a) {
        Item i = new Item(n, a);
        logger.info(n + " 물건의 " + a + " 입력 및 생성 완료! ");
        items.add(i);
    }

    /**
     * getter.
     *
     * @param index is items Index
     * @author kIm kyu hyeong
     */
    public String getName(int index) {
        if (items.size() == 0) {
            logger.warn("리스트가 비어있기에 getName 불가능");
            throw new ArrayIndexOutOfBoundsException("구매 리스트가 비어있습니다.");
        }
        return items.get(index).name;
    }

    /**
     * getter.
     *
     * @param index is items Size
     * @author kIm kyu hyeong
     */
    public int getAmount(int index) {
        if (items.size() == 0) {
            logger.warn("리스트가 비어있기에 getAmount 불가능");
            throw new ArrayIndexOutOfBoundsException("구매 리스트가 비어있습니다.");
        }
        return items.get(index).amount;
    }

    public int size() {
        return items.size();
    }

    /**
     * Item generator.
     *
     * @author kIm kyu hyeong
     */
    public static class Item {
        private final String name;
        private final int amount;

        Item(String s, int a) {
            if (a < 0) {
                logger.warn("음수가 입력됨");
                throw new IllegalArgumentException("음수는 살수 없습니다.");
            }
            this.name = s;
            this.amount = a;
        }


    }
}
