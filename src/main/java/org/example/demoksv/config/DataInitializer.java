package org.example.demoksv.config;

import org.example.demoksv.entity.User;
import org.example.demoksv.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            userRepository.save(
                new User(
                    "admin",
                    passwordEncoder.encode("admin123"),
                    "ADMIN"
                )
            );

            userRepository.save(
                new User(
                    "user",
                    passwordEncoder.encode("user123"),
                    "USER"
                )
            );
        };
    }
}