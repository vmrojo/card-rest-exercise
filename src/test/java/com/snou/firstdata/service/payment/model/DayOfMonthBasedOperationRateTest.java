package com.snou.firstdata.service.payment.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DayOfMonthBasedOperationRateTest {

    @Test
    public void test() {
        LocalDate date = LocalDate.of(2018, 10, 15);
        OperationRate opRate = new DayOfMonthBasedOperationRate(date);
        
        BigDecimal rate = opRate.calculateRate();
        
        Assert.assertEquals(new BigDecimal("7.5").compareTo(rate), 0);
    }

}
