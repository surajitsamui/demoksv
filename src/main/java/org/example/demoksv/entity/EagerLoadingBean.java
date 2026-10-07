package org.example.demoksv.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

@Component
public class EagerLoadingBean {

    public EagerLoadingBean(){
        System.out.println("EagerLoadingBean Object Created");
    }
}
