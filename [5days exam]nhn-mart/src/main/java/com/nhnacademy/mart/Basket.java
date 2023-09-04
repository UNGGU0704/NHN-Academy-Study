package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bakset is Collection that get Food.
 *
 * @author kIm kyu hyeong
 */
public class Basket {
    private final ArrayList<Food> foods = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

    public void add(Food food) {
        logger.info(food.getName() + "을 Basket에 추가하였습니다.");
        foods.add(food);
    }

    /**
     * getter.
     *
     * @param index is foods Index
     * @author kIm kyu hyeong
     */
    public Food get(int index) {
        if (foods.size() <= 0) {
            throw new ArrayIndexOutOfBoundsException("Foods가 비었습니다.");
        }
        return foods.get(index);
    }

    public int size() {
        return foods.size();
    }
}
