package org.nhnmart;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NHN_Mart.
 *
 *
 * @author KIM KYU HYEONG
 *
 */


public class NhnMart {
    private static final Logger logger = LoggerFactory.getLogger(NhnMart.class);

    /**
     * main 함수입니다.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringTokenizer st;
        ArrayList<String> items = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고싶은 물건을 골라주세요.");
        st = new StringTokenizer(s.nextLine());

        int buyCount = 0;
        String item = null;
        int count = 0;
        while (st.hasMoreTokens()) {
            item = st.nextToken();
            try {
                count = Integer.parseInt(st.nextToken());
            } catch (NoSuchElementException e) {
                logger.warn("물건을 입력했으면 수량도 적어줘야합니다.");
                throw new NoSuchElementException("구매할 제품의 수량을 적지 않았습니다.");
            }
            items.add(item);
            counts.add(count);
            buyCount++;
        }

        // 압력 종료

        isTrade(items, counts, buyCount);

        s.close();
    }

    static void isTrade(ArrayList<String> items, ArrayList<Integer> counts, int buyCount) {
        Mart nhnMart = new Mart();
        Customer customer = new Customer(20000);
        int totalPrice = 0; // 총 쇼핑 가격

        for (int i = 0; i < buyCount; i++) {

            String buyItem = items.get(i);
            int buyAmount = counts.get(i);
            logger.info("물건 구매 : {} , {}", buyItem, buyAmount);

            totalPrice += nhnMart.isSell(buyItem, buyAmount);
        }

        customer.isBuy(totalPrice);

        System.out.println("총 가격은 "
                + totalPrice
                + " 입니다. \n"
                + "고객님 결제 후 잔액 : "
                + customer.getMoney());
    }
}
