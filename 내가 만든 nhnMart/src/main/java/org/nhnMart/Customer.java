package org.nhnmart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Customer.java is Customer Object.
 *
 *
 * @author KIM KYU HYEONG
 *
 */
public class Customer {
    private static final Logger logger = LoggerFactory.getLogger(Customer.class);
    private int money;

    Customer(int m) {
        this.money = m;
    }

    /** isBuy is calcurate money.
     *
     *
     * @param  m is money
     */
    public void isBuy(int m) {
        int newMoney = this.money - m;
        if (newMoney < 0) {
            logger.warn("돈이 부족합니다.");
            throw new IllegalArgumentException("돈이 부족합니다.");
        } else {
            this.money = newMoney;
        }
    }

    public int getMoney() {
        return this.money;
    }
}
