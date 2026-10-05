package org.example.demoksv.kafka.serviceconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumerService {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(
            topics = "my-topic",
            groupId = "my-test-group"
    )
    public void consume(String message) {
        System.out.println("================================");
        System.out.println("KAFKA RECEIVED: " + message);
        System.out.println("================================");
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}