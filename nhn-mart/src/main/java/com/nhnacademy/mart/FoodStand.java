package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is FoodStand include Food list.
 *
 * @author kIm kyu hyeong
 */
public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(Customer.class);
    // TODO add 메서드 구현
    public void add(Food a) {
        foods.add(a);
    }

    /**
     * This is Main().
     *
     * @param index is Foods reference Index.
     * @author kIm kyu hyeong
     */
    public Food get(int index) {
        if (foods.size() == 0) {
            logger.warn("푸드 리스트가 비었기에 get 불가능! ");
            throw new ArrayIndexOutOfBoundsException("푸드리스트가 비었어요.");
        }
        return foods.get(index);
    }

    public int size() {
        return foods.size();
    }

    /**
     * This is Main().
     *
     * @param index is Foods delete index
     * @author kIm kyu hyeong
     */
    // TODO 장바구니에 담은 Food 삭제 구현
    public void delete(int index) {
        if (foods.size() == 0) {
            logger.warn("FoodStand가 비었기에 delete불가능! ");
            throw new ArrayIndexOutOfBoundsException(" 푸드 스탠드가 비었어요.");
        }
        foods.remove(index);
    }
}
