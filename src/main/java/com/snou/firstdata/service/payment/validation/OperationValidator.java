package com.snou.firstdata.service.payment.validation;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.snou.firstdata.service.exception.ApplicationException;
import com.snou.firstdata.service.payment.model.PaymentOperation;

@Component
public class OperationValidator implements Validator {

    public static final BigDecimal OPERATION_AMOUNT_MAX_LIMIT = new BigDecimal("1000.00");
    
    public void validate(Object obj) throws ApplicationException {
        if(!(obj instanceof PaymentOperation)) {
            throw new ApplicationException("Operation cannot be validated");
        }

        PaymentOperation op = (PaymentOperation) obj;
        
        if(op.getAmount() == null) {
            throw new ApplicationException("Not a valid amount");
        }
        if(op.getAmount().compareTo(OPERATION_AMOUNT_MAX_LIMIT) >= 1) {
            throw new ApplicationException("Not a valid operation. Amount cannot exceed limit");
        }
    }

}
