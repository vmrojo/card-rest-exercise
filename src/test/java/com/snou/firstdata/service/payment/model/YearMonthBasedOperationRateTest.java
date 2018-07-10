package com.snou.firstdata.service.payment.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class YearMonthBasedOperationRateTest {

    @Test
    public void yearMonthOperationRateTest() {
        LocalDate date = LocalDate.of(2018, 10, 1);
        OperationRate opRate = new YearMonthBasedOperationRate(date);
        
        BigDecimal rate = opRate.calculateRate();
        
        Assert.assertEquals(new BigDecimal("201.8").compareTo(rate), 0);
    }

}
