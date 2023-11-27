package com.nhnacademy.mart;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Food Class is Food status.
 *
 * @author kIm kyu hyeong
 */
public class Food {

    private final String name;
    private final int price;
    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

    /**
     * This is FoodStand include Food list.
     *
     * @param n is Food name
     * @param p is Food Price
     * @author kIm kyu hyeong
     */
    public Food(String n, int p) {
        if (p < 0) {
            logger.warn("가격이 음수가 입력됨.");
            throw new IllegalArgumentException("가격은 음수가 될 수 없습니다;.");
        }
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
