package com.snou.firstdata.service.payment.model;

import java.math.BigDecimal;

import com.snou.firstdata.service.dao.Identifiable;

public class PaymentOperation implements Identifiable{

    private Long id;
    private BigDecimal amount;
    
    public PaymentOperation() {
     
    }
    
    public PaymentOperation(BigDecimal amount) {
        this(0, amount);
    }
    
    public PaymentOperation(long id, BigDecimal amount) {
        this.amount = amount;
    }
    
    public Long getId() {
        return id;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
}
