package org.example.demoksv.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LazyLoadingBean {
    public LazyLoadingBean(){
        System.out.println("LazyLoadingBean Object Created");
    }
}
