package com.snou.firstdata.service.payment.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DayOfMonthBasedOperationRate implements OperationRate {

    private static final BigDecimal DEFAULT_FACTOR = new BigDecimal("0.5");
    
    private LocalDate date;
    private BigDecimal factor;

    public DayOfMonthBasedOperationRate() {
        this(LocalDate.now());
    }

    public DayOfMonthBasedOperationRate(LocalDate date) {
        this(date, DEFAULT_FACTOR);
    }
    
    public DayOfMonthBasedOperationRate(LocalDate date, BigDecimal factor) {
        this.date = date;
        this.factor = factor;
    }

    public BigDecimal calculateRate() {
        return BigDecimal.valueOf(date.getDayOfMonth()).multiply(factor);
    }

}
