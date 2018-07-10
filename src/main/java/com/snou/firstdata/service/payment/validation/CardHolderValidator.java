package com.snou.firstdata.service.payment.validation;

import com.snou.firstdata.service.exception.ApplicationException;
import com.snou.firstdata.service.payment.model.CardInfo;

public class CardHolderValidator implements Validator {

    public void validate(Object obj) throws ApplicationException {
        //should be valid by this point
        CardInfo card = (CardInfo) obj;
        
        if(card.getCardHolder() == null || card.getCardHolder().isEmpty()) {
            throw new ApplicationException("validation field is missing: Cardholder");
        }
    }

}
