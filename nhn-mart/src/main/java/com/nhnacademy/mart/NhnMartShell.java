package com.nhnacademy.mart;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NhnMartShell {

    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer kyuHyeong = new Customer(buyList);

        // 장바구니를 챙긴다.
        kyuHyeong.bring(mart.provideBasket());

        // 식품을 담는다.
        kyuHyeong.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        kyuHyeong.payTox(mart.getCounter());
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
                throw new NoSuchElementException("구매할 제품의 수량을 적지 않았습니다.");
            }
            buyList.add(item, amount);
        }
        return buyList;
    }
}
