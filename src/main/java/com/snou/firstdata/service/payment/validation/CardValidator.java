package com.snou.firstdata.service.payment.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.snou.firstdata.service.exception.ApplicationException;
import com.snou.firstdata.service.payment.model.CardInfo;

@Component
public class CardValidator implements Validator{

    List<Validator> validations;
    
    public CardValidator() {
        validations = new ArrayList<Validator>();
        
        validations.add(new CardExpDateValidator());
        validations.add(new CardNumberValidator());
        validations.add(new CardHolderValidator());
    }
    
    public CardValidator(List<Validator> validations) {
        this.validations = validations;
    }

    public void validate(Object obj) throws ApplicationException {
        if(!(obj instanceof CardInfo)) {
            throw new ApplicationException("Card information cannot be validated");
        }
        
        CardInfo card = (CardInfo) obj;
        
        if(card.getBrand() == null) {
            throw new ApplicationException("validation field is missing: Brand type");
        }
        
        for(Validator validation : validations) {
            validation.validate(card);
        }
    }
    
}