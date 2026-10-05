package org.example.demoksv.kafka.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.example.demoksv.kafka.serviceconsumer.KafkaConsumerService;
import org.example.demoksv.kafka.serviceproducer.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@SecurityRequirement(name = "bearerAuth")
public class KafkaController {

    private final KafkaProducerService producerService;
    private final KafkaConsumerService consumerService;

    public KafkaController(KafkaProducerService producerService, KafkaConsumerService consumerService) {
        this.producerService = producerService;
        this.consumerService = consumerService;
    }

    @PostMapping("/send")
    public String send(@RequestParam String message) {
        producerService.sendMessage(message);
        return "Message sent successfully";
    }

    @GetMapping("/messages")
    public List<String> getMessages() {
        return consumerService.getMessages();
    }
}