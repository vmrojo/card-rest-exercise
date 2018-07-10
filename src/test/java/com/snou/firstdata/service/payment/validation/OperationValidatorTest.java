package com.snou.firstdata.service.payment.validation;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.snou.firstdata.service.exception.ApplicationException;
import com.snou.firstdata.service.payment.model.PaymentOperation;

public class OperationValidatorTest {

    @Test
    public void nullAmountTest() {
        PaymentOperation op = new PaymentOperation(null);
        
        OperationValidator validator = new OperationValidator();
        String message = "";
        try {
            validator.validate(op);
            fail("ApplicationException was expected. Amount cannot be null");
        }
        catch (ApplicationException e) {
            message = e.getMessage();
        }

        assertTrue(message.contains("Not a valid amount"));
    }
    
    @Test
    public void amountUnderOperationLimitTest() {
        BigDecimal amountUnderLimit = OperationValidator.OPERATION_AMOUNT_MAX_LIMIT
                                                        .subtract(BigDecimal.ONE);
        PaymentOperation op = new PaymentOperation(amountUnderLimit);
        
        OperationValidator validator = new OperationValidator();
        try {
            validator.validate(op);
        }
        catch (ApplicationException e) {
            fail("No ApplicationException was expected: " + e.getMessage());
        }
    }
    
    @Test
    public void amountOverOperationLimitTest() {
        BigDecimal amountOverLimit = OperationValidator.OPERATION_AMOUNT_MAX_LIMIT
                                                       .add(BigDecimal.ONE);
        PaymentOperation op = new PaymentOperation(amountOverLimit);
        
        OperationValidator validator = new OperationValidator();
        String message = "";
        try {
            validator.validate(op);
            fail("ApplicationException was expected. Amount cannot exceed limit");
        }
        catch (ApplicationException e) {
            message = e.getMessage();
        }

        assertTrue(message.contains("Amount cannot exceed limit"));
    }

}
