package com.snou.firstdata.service.payment.validation;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.snou.firstdata.service.exception.ApplicationException;
import com.snou.firstdata.service.payment.model.CardInfo;

public class CardExpDateValidator implements Validator {

    public static final String EXPDATE_FORMAT = "MMyy";
    
    
    public void validate(Object obj) throws ApplicationException {
        CardInfo card = (CardInfo) obj;
        
        if(card.getExpDate() == null) {
            throw new ApplicationException("validation field is missing: expiration date");
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(EXPDATE_FORMAT);
        YearMonth yearMonth;
        
        try{
            yearMonth = YearMonth.parse(card.getExpDate(), formatter);
        }
        catch (DateTimeParseException e) {
            throw new ApplicationException("incorrect expiration date format", e);
        }
        
        if(LocalDate.now().isAfter(yearMonth.atDay(1))){
            throw new ApplicationException("card has expired");
        }
        
        
    }

}
