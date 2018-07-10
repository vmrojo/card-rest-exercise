package com.snou.firstdata.service.payment.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardInfoTest {

    @Test
    public void cardsMatchTest() {
        CardInfo card1 = new CardInfo(CardBrandEnum.PERE, "0000000000000000", "John Doe", "0118");
        CardInfo card2 = new CardInfo(CardBrandEnum.PERE, "0000000000000000", "John Doe", "0118");
        
        assertTrue(card1.equals(card2));
    }
    
    @Test
    public void cardBrandDoesNotMatchTest() {
        CardInfo card1 = new CardInfo(CardBrandEnum.PERE, "0000000000000000", "John Doe", "0118");
        CardInfo card2 = new CardInfo(CardBrandEnum.SCO, "0000000000000000", "John Doe", "0118");
        
        assertFalse(card1.equals(card2));
    }
    
    @Test
    public void cardNumberDoesNotMatchTest() {
        CardInfo card1 = new CardInfo(CardBrandEnum.PERE, "0000000000000000", "John Doe", "0118");
        CardInfo card2 = new CardInfo(CardBrandEnum.PERE, "1111111111111111", "John Doe", "0118");
        
        assertFalse(card1.equals(card2));
    }
    
    @Test
    public void cardHolderDoesNotMatchTest() {
        CardInfo card1 = new CardInfo(CardBrandEnum.PERE, "0000000000000000", "John Doe", "0118");
        CardInfo card2 = new CardInfo(CardBrandEnum.PERE, "0000000000000000", "Jane Doe", "0118");
        
        assertFalse(card1.equals(card2));
    }
    
    @Test
    public void cardExpDateDoesNotMatchTest() {
        CardInfo card1 = new CardInfo(CardBrandEnum.PERE, "0000000000000000", "John Doe", "0118");
        CardInfo card2 = new CardInfo(CardBrandEnum.PERE, "0000000000000000", "John Doe", "0119");
        
        assertFalse(card1.equals(card2));
    }
    
    @Test
    public void hashCodesMatchTest() {
        CardInfo card1 = new CardInfo(CardBrandEnum.PERE, "0000000000000000", "John Doe", "0118");
        CardInfo card2 = new CardInfo(CardBrandEnum.PERE, "0000000000000000", "John Doe", "0118");
        
        assertTrue(card1.hashCode() == card2.hashCode());
    }

}
