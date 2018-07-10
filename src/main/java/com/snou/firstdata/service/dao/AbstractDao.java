package com.snou.firstdata.service.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.snou.firstdata.service.util.IdGenerator;

public abstract class AbstractDao<T extends Identifiable> implements Dao<T>{

    @Autowired
    private IdGenerator idGen;
    private List<T> elements = Collections.synchronizedList(new ArrayList<>());
    
    
    public T create(T element) {
        element.setId(idGen.getNext());
        elements.add(element);
        return element;
    }

    public List<T> findAll() {
        return elements;
    }

    public Optional<T> findById(Long id) {
        return elements.stream()
                       .filter(e -> e.getId().equals(id))
                       .findFirst();
    }

    public boolean update(Long id, T update) {
        Optional<T> element = findById(id);
        element.ifPresent(original -> updateIfExists(original, update));
        return element.isPresent();
    }
    
    protected abstract void updateIfExists(T original, T update);

    public boolean delete(Long id) {
        return elements.removeIf(e -> e.getId().equals(id));
    }

}
