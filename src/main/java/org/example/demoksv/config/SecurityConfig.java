package org.example.demoksv.config;

import org.example.demoksv.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

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

                        // LOGIN - PUBLIC
                        .requestMatchers("/auth/**").permitAll()
                        // SWAGGER - PUBLIC
                        .requestMatchers(
                                "/swagger-ui.html",
                                "/index.html",
                                "/swagger-ui/**",
                                "/api-docs/**"
                        ).permitAll()

                        // EMPLOYEES
                        .requestMatchers(HttpMethod.GET, "/employees/**")
                        .hasAnyRole("USER", "ADMIN")

                        .requestMatchers("/employees/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/**")
                        .hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/kafka/**")
                        .hasAnyRole("USER", "ADMIN")

                        .anyRequest().authenticated()
                )

                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();
    }
}


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http)
//            throws Exception {
//
//        http
//                // Important for REST/JWT
//                .csrf(csrf -> csrf.disable())
//
//                .sessionManagement(session ->
//                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//
//                .authorizeHttpRequests(auth -> auth
//
//                        // Login MUST be public
//                        .requestMatchers("/auth/login").permitAll()
//
//                        // Swagger
//                        .requestMatchers(
//                                "/swagger-ui.html",
//                                "/swagger-ui/**",
//                                "/api-docs/**"
//                        ).permitAll()
//
//                        // Employee APIs
//                        .requestMatchers(HttpMethod.GET, "/employees/**")
//                        .hasAnyRole("USER", "ADMIN")
//
//                        .requestMatchers("/employees/**")
//                        .hasRole("ADMIN")
//
//                        .anyRequest().authenticated()
//                )
//
//                .addFilterBefore(
//                        jwtAuthenticationFilter,
//                        UsernamePasswordAuthenticationFilter.class
//                );
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }
//}