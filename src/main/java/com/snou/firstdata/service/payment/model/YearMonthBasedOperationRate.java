package com.snou.firstdata.service.payment.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class YearMonthBasedOperationRate implements OperationRate {

    private LocalDate date;
    
    public YearMonthBasedOperationRate() {
        this(LocalDate.now());
    }
    
    public YearMonthBasedOperationRate(LocalDate date) {
        this.date = date;
    }
    
    public BigDecimal calculateRate() {
        return BigDecimal.valueOf(date.getYear()).divide(
               BigDecimal.valueOf(date.getMonth().getValue()), RoundingMode.FLOOR); 
    }
    
}
