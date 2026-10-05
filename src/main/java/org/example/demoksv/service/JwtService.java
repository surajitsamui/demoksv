package org.example.demoksv.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey key;

    public JwtService() {

        String secret =
                "my-super-secret-key-for-demoksv-project-123456789";

        key = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );
    }

    public String generateToken(UserDetails userDetails) {

        Date now = new Date();

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(now)
                .expiration(
                        new Date(
                                now.getTime() + 3600000)
                )
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean isValid(
            String token,
            UserDetails userDetails) {

        try {

            String username =
                    extractUsername(token);

            return username.equals(
                    userDetails.getUsername());

        } catch (Exception e) {

            return false;
        }
    }
}