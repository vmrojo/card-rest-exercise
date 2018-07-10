package com.snou.firstdata.service.resource;

import org.springframework.hateoas.ResourceSupport;

import com.snou.firstdata.service.payment.model.CardBrandEnum;
import com.snou.firstdata.service.payment.model.CardInfo;

public class CardInfoResource extends ResourceSupport {

    private CardBrandEnum brand;
    private String cardNumber;
    private String cardHolder;
    private String expDate;

    public CardInfoResource(CardInfo card) {
        this.brand = card.getBrand();
        this.cardNumber = card.getCardNumber();
        this.cardHolder = card.getCardHolder();
        this.expDate = card.getExpDate();
    }

    public CardBrandEnum getBrand() {
        return brand;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setBrand(CardBrandEnum brand) {
        this.brand = brand;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

}
