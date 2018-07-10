package com.snou.firstdata.service.payment.validation;

import static org.junit.Assert.fail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Assert;
import org.junit.Test;

import com.snou.firstdata.service.exception.ApplicationException;
import com.snou.firstdata.service.payment.model.CardInfo;

public class CardExpDateValidatorTest {

    @Test
    public void cardExpDateIsNullTest() {
        CardInfo card = new CardInfo();
        card.setExpDate(null);
        
        CardExpDateValidator validator = new CardExpDateValidator();
        String msg = "";
        try {
            validator.validate(card);
            fail("ApplicationException was expected. ExpDate field cannot be null");
        }
        catch (ApplicationException e) {
            msg = e.getMessage();
        }
        
        Assert.assertTrue(msg.toLowerCase().contains("expiration date"));
    }
    
    @Test
    public void cardExpDateIncorrectFormatTest() {
        CardInfo card = new CardInfo();
        card.setExpDate("00118");
        
        CardExpDateValidator validator = new CardExpDateValidator();
        String msg = "";
        try {
            validator.validate(card);
            fail("ApplicationException was expected. Incorrect ExpDate format");
        }
        catch (ApplicationException e) {
            msg = e.getMessage();
        }
        
        Assert.assertTrue(msg.toLowerCase().contains("incorrect expiration date format"));
    }
    
    @Test
    public void cardIsExpiredTest() {
        LocalDateTime someMonthsAgo = LocalDateTime.now().minus(3, ChronoUnit.MONTHS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CardExpDateValidator.EXPDATE_FORMAT);
        
        CardInfo card = new CardInfo();
        card.setExpDate(formatter.format(someMonthsAgo));
        
        CardExpDateValidator validator = new CardExpDateValidator();
        String msg = "";
        try {
            validator.validate(card);
            fail("ApplicationException was expected. Card has expired");
        }
        catch (ApplicationException e) {
            msg = e.getMessage();
        }
        
        Assert.assertTrue(msg.toLowerCase().contains("expired"));
    }

}
