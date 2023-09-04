package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Customer does buy in Mart.
 *
 * @author kIm kyu hyeong
 */
public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

    public Customer(BuyList buyList) {
        if (buyList == null) {
            throw new Error("BuyList 가 null 입니다.");
        }
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        if (basket == null) {
            throw new Error("Basket 가 null 입니다.");
        }
        this.basket = basket;
    }

    // TODO pickFoods 메서드 구현

    /**
     * pickFood Method.
     *
     * @param foodStand is Food in Marth
     * @author kIm kyu hyeong
     */
    public void pickFoods(FoodStand foodStand) {
        ArrayList<String> buyItems = new ArrayList<>();


        int standsize = foodStand.size();
        int size = buyList.size();

        for (int i = 0; i < size; i++) {
            String item = buyList.getName(i); // 사야할 아이템 이름 받아오기
            int amounts = buyList.getAmount(i); // 수량 받아오기
            logger.info(item + "을 " + amounts + "개 사야합니다.");
            for (int j = 0; j < amounts; j++) {
                buyItems.add(item); // 수량 만큼 이름을 담음
            }

        }

        for (String item : buyItems) { // 살 목록의 이름을 받아서
            for (int i = 0; i < standsize; i++) { //
                if (foodStand.get(i).getName().equals(item)) { // 스탠드 있는 Food 중에 같은 이름을 찾는다.
                    Food buyFood = foodStand.get(i);
                    basket.add(buyFood); // 내 바스켓에 담는다.
                    foodStand.delete(i); // 푸드 스탠드에서는 지운다.
                    logger.info(buyFood.getName() + "은 푸드스탠드에서 하나가 감소하였습니다.");
                    break;
                }
                if (i == standsize - 1) {
                    logger.warn("물건이 없음! ");
                    throw new IllegalArgumentException("찾으시는 물건이 없습니다.");
                }

            }
        }


    }


    // TODO payTox 메서드 구현

    /**
     * payTox method.
     *
     * @param foodStand is Food in Mart
     * @author kIm kyu hyeong
     */
    public void payTox(FoodStand foodStand) {
        Counter c = new Counter();

        c.pay(basket);
    }

}
