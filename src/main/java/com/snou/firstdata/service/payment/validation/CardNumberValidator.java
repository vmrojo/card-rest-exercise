package com.snou.firstdata.service.payment.validation;

import com.snou.firstdata.service.exception.ApplicationException;
import com.snou.firstdata.service.payment.model.CardInfo;

public class CardNumberValidator implements Validator {

    public void validate(Object obj) throws ApplicationException {
        //should be valid by this point
        CardInfo card = (CardInfo) obj;
        
        if(card.getCardNumber() == null || card.getCardNumber().isEmpty()) {
            throw new ApplicationException("validation field is missing: Card number");
        }
        
        //Other validations could include length and format depending on brand
    }

}
