package com.snou.firstdata.service.payment.model;

import com.snou.firstdata.service.dao.Identifiable;

public class CardInfo implements Identifiable{

    private Long id;
    
    private CardBrandEnum brand;
    private String cardNumber;
    private String cardHolder;
    private String expDate;
    
    public CardInfo() {
        
    }
    
    public CardInfo(CardBrandEnum brand, String cardNumber, String cardHolder, String expDate) {
        this.brand = brand;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expDate = expDate;
    }
    
    @Override
    public Long getId() {
        return id;
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
    
    @Override
    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((cardHolder == null) ? 0 : cardHolder.hashCode());
        result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
        result = prime * result + ((expDate == null) ? 0 : expDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CardInfo other = (CardInfo) obj;
        if (brand != other.brand)
            return false;
        if (cardHolder == null) {
            if (other.cardHolder != null)
                return false;
        } else if (!cardHolder.equals(other.cardHolder))
            return false;
        if (cardNumber == null) {
            if (other.cardNumber != null)
                return false;
        } else if (!cardNumber.equals(other.cardNumber))
            return false;
        if (expDate == null) {
            if (other.expDate != null)
                return false;
        } else if (!expDate.equals(other.expDate))
            return false;
        return true;
    }
    
}
