package com.snou.firstdata.service.resource;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.snou.firstdata.service.payment.model.PaymentOperation;

public class PaymentOperationResource extends ResourceSupport {

    private Long id;
    private BigDecimal amount;

    public PaymentOperationResource() {
        
    }
    
    public PaymentOperationResource(PaymentOperation operation) {
        this.id = operation.getId();
        this.amount = operation.getAmount();
    }

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setResourceId(Long id) {
        this.id = id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
