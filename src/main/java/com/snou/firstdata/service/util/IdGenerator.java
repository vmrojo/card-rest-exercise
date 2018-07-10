package com.snou.firstdata.service.util;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class IdGenerator {

    private AtomicLong idGen = new AtomicLong(1);
    
    public long getNext() {
        return idGen.getAndIncrement();
    }
    
}
