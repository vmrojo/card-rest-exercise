package com.snou.firstdata.service.payment.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MonthBasedOperationRate implements OperationRate{

    private static final BigDecimal DEFAULT_FACTOR = new BigDecimal("0.1"); 
    
    private LocalDate date;
    private BigDecimal factor;

    public MonthBasedOperationRate() {
        this(LocalDate.now());
    }

    public MonthBasedOperationRate(LocalDate date) {
        this(date, DEFAULT_FACTOR);
    }
    
    public MonthBasedOperationRate(LocalDate date, BigDecimal factor) {
        this.date = date;
        this.factor = factor;
    }

    public BigDecimal calculateRate() {
        return BigDecimal.valueOf(date.getMonth().getValue()).multiply(factor);
    }
    
}
