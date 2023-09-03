package com.nhnacademy.mart;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NhnMartShell is Main().
 *
 * @author kIm kyu hyeong
 */

public class NhnMartShell {
    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

    /**
     * This is Main().
     *
     * @author kIm kyu hyeong
     */
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer kyuHyeong = new Customer(buyList);
        logger.info("생성자 정상 실행 완료! ");
        // 장바구니를 챙긴다.
        kyuHyeong.bring(mart.provideBasket());
        logger.info("장바구니를 챙겼습니다. ");
        // 식품을 담는다.
        kyuHyeong.pickFoods(mart.getFoodStand());
        logger.info("음식을 챙겼습니다.");
        // 카운터에서 계산한다.
        kyuHyeong.payTox(mart.getCounter());
        logger.info("모든 계산이 끝났습니다...");
    }

    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기
        Scanner s = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(s.nextLine());

        BuyList buyList = new BuyList();

        String item;
        int amount;
        while (st.hasMoreTokens()) {
            item = st.nextToken();
            try {
                amount = Integer.parseInt(st.nextToken());
            } catch (NoSuchElementException e) {
                logger.warn("입력값 문제! 제품의 수량을 정확하게 입력하세요. ");
                throw new NoSuchElementException("구매할 제품의 수량을 적지 않았습니다.");
            }
            buyList.add(item, amount);
        }
        return buyList;
    }
}
