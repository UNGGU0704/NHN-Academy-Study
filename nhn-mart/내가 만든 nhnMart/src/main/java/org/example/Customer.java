package org.example;

public class Customer {
    private int money;

    Customer(int m) {
        this.money = m;
    }

    public void isBuy(int m){
        int newMoney = this.money - m;
        if (newMoney < 0) {
           throw new IllegalArgumentException("돈이 부족합니다.");
        } else {
            this.money = newMoney;
        }

    }

    public int getMoney(){
        return this.money;
    }
}
