package org.example.demoksv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                .authorizeHttpRequests(auth -> auth

                        // Swagger - PUBLIC
                        .requestMatchers(
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/api-docs/**"
                        ).permitAll()

                        // Employee GET - authenticated
                        .requestMatchers(
                                HttpMethod.GET,
                                "/employees/**"
                        ).authenticated()

                        // Employee POST/PUT/DELETE - authenticated
                        .requestMatchers(
                                HttpMethod.POST,
                                "/employees/**"
                        ).authenticated()

                        .requestMatchers(
                                HttpMethod.PUT,
                                "/employees/**"
                        ).authenticated()

                        .requestMatchers(
                                HttpMethod.DELETE,
                                "/employees/**"
                        ).authenticated()

                        // Kafka GET - authenticated
                        .requestMatchers(
                                HttpMethod.GET,
                                "/kafka/**"
                        ).authenticated()

                        // Everything else
                        .anyRequest().authenticated()
                )

                // Keycloak JWT
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(withDefaults())
                );

        return http.build();
    }

    // Required by DataInitializer
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}