package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class buyTest {

    @Test
    @DisplayName("구매 리스트가  비어있는 테스트(이름) ")
    public void emptyNameBuyList(){
        BuyList buyList = new BuyList();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> buyList.getName(0));
    }

    @Test
    @DisplayName("구매 리스트가 비어있는 테스트(수량) ")
    public void emptyBuyAmountList(){
        BuyList buyList = new BuyList();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> buyList.getAmount(0));
    }

    @Test
    @DisplayName("구매 수량 음수 테스트")
    public void minusBuyList(){
        BuyList buyList = new BuyList();
        Assertions.assertThrows(IllegalArgumentException.class, () -> buyList.add("초코우유", -1 ));
    }


}
