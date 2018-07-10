package com.snou.firstdata.service.dao.impl;

import org.springframework.stereotype.Repository;

import com.snou.firstdata.service.dao.AbstractDao;
import com.snou.firstdata.service.payment.model.CardInfo;

@Repository
public class CardDao extends AbstractDao<CardInfo> {
    
    @Override
    protected void updateIfExists(CardInfo original, CardInfo update) {
        original.setBrand(update.getBrand());
        original.setCardNumber(update.getCardNumber());
        original.setCardHolder(update.getCardHolder());
        original.setExpDate(update.getExpDate());
    }

}
