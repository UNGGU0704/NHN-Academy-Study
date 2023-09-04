package com.nhnacademy.mart;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Counter is exectue pay System.
 *
 * @author kIm kyu hyeong
 */
public class Counter {

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)
    private int totalMoney = 0;
    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

    /**
     * pay Method.
     *
     * @param basket is Collections is buyList
     * @author kIm kyu hyeong
     */
    void pay(Basket basket) {
        logger.info("계산 중... ");
        if (basket.size() == 0) {
            logger.warn("바스켓이 비어있음! ");
            throw new Error("바스켓이 비어있습니다.");
        } else if (basket == null) {
            logger.warn("바스켓이 null 임");
            throw new NullPointerException("바스켓이 null 입니다.");
        }


        for (int i = 0; i < basket.size(); i++) {
            totalMoney += basket.get(i).getPrice();
        }

        if (totalMoney > 20000) {
            logger.warn("돈이 부족!");
            throw new Error("돈이 부족합니다.");
        }

        System.out.println("총 가격은 "
                + totalMoney
                + " 원 입니다.\n"
                + "고객님 결제 후 잔액 : "
                + (20000 - totalMoney));
    }


}
