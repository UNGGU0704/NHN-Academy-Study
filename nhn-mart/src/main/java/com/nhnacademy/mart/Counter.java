package com.nhnacademy.mart;

public class Counter {

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)
    private int totalMoney = 0;
    void pay(Basket basket){
        if(basket.size() == 0 ) {
            throw new Error("바스켓이 비어있습니다.");
        } else if(basket == null) {
            throw new NullPointerException("바스켓이 null 입니다.");
        }



        for (int i = 0; i < basket.size(); i++) {
            totalMoney += basket.get(i).getPrice();
        }

        if(totalMoney > 20000) throw new Error("돈이 부족합니다.");

        System.out.println("총 가격은 " + totalMoney + " 원 입니다.\n" +
                "고객님 결제 후 잔액 : " + (20000 - totalMoney));
    }


}
