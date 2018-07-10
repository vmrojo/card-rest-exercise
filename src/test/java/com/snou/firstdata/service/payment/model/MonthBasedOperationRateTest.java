package com.snou.firstdata.service.payment.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class MonthBasedOperationRateTest {

    @Test
    public void test() {
        LocalDate date = LocalDate.of(2018, 12, 1);
        OperationRate opRate = new MonthBasedOperationRate(date);
        
        BigDecimal rate = opRate.calculateRate();
        
        Assert.assertEquals(new BigDecimal("1.2").compareTo(rate), 0);
    }

}
