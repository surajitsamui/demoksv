package org.example.demoksv.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@SecurityRequirement(name = "bearerAuth")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping
    public String chat(@RequestParam String message) {

        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }
}