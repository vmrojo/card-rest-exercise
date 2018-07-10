package com.snou.firstdata.service.payment.validation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.snou.firstdata.service.exception.ApplicationException;
import com.snou.firstdata.service.payment.model.CardBrandEnum;
import com.snou.firstdata.service.payment.model.CardInfo;

public class CardValidatorTest {

    
    
    @Test
    public void validCardTest() {
        CardInfo card = new CardInfo(CardBrandEnum.PERE, "0000000000000000", "John Doe", "0118");
        
        //empty list of additional validators
        Validator validator = new CardValidator(new ArrayList<Validator>());
        
        try{
            validator.validate(card);
        }
        catch (ApplicationException e) {
            fail("No exception should be thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void nullCardTest() {
        CardInfo card = null;
        
        Validator validator = new CardValidator();
        String message = "";
        try{
            validator.validate(card);
            fail("Null card should throw an exception when validated");
        }
        catch (ApplicationException e) {
            message = e.getMessage();
        }
        
        assertTrue(message.contains("cannot be validated"));
    }

}
