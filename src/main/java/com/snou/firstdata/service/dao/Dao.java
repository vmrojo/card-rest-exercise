package com.snou.firstdata.service.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends Identifiable> {

    public T create(T element);
    
    public List<T> findAll();
    public Optional<T> findById(Long id);
    
    public boolean update(Long id, T update);
    
    public boolean delete(Long id);
    
    
    
}
