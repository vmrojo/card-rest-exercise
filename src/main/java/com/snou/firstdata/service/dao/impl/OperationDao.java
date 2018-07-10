package com.snou.firstdata.service.dao.impl;

import org.springframework.stereotype.Repository;

import com.snou.firstdata.service.dao.AbstractDao;
import com.snou.firstdata.service.payment.model.PaymentOperation;

@Repository
public class OperationDao extends AbstractDao<PaymentOperation> {

    @Override
    protected void updateIfExists(PaymentOperation original, PaymentOperation update) {
        original.setAmount(update.getAmount());
    }

}
