package org.example.demoksv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
@EnableKafka
public class DemoksvApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoksvApplication.class, args);
    }
}