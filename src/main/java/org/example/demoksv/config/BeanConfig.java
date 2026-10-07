package org.example.demoksv.config;

import org.example.demoksv.beanclasses.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    public TestBean testBeanNew(){
        return new TestBean();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
