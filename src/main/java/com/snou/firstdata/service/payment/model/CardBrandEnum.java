package com.snou.firstdata.service.payment.model;

public enum CardBrandEnum {
    
    SQUA("SQUA"),
    SCO("SCO"),
    PERE("PERE");
    
    private String brand;
    
    private CardBrandEnum(String brand) {
        this.brand = brand;
    }
    
    public String getBrand() {
        return brand;
    }
    
    @Override
    public String toString() {
        return getBrand();
    }

}
