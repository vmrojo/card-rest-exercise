package com.snou.firstdata.service.dao;

public interface Identifiable extends org.springframework.hateoas.Identifiable<Long>{

    public void setId(Long id);
    
}
