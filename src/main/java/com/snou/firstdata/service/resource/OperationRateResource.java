package com.snou.firstdata.service.resource;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import com.snou.firstdata.service.payment.model.CardBrandEnum;

public class OperationRateResource extends ResourceSupport {

    private CardBrandEnum brand;
    private BigDecimal amount;
    private BigDecimal rate;

    public CardBrandEnum getBrand() {
        return brand;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public BigDecimal getRate() {
        return rate;
    }

    public void setBrand(CardBrandEnum brand) {
        this.brand = brand;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

}
