package com.snou.firstdata.service.payment.validation;

import com.snou.firstdata.service.exception.ApplicationException;

public interface Validator {

    public void validate(Object obj) throws ApplicationException;
    
}
