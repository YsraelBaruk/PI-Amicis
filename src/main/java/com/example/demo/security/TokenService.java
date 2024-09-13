package com.example.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String token;

    public String gerarToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(token);
            return JWT.create()
                    .withIssuer("demo")
                    .withSubject(user.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            System.out.println(user.getLogin() + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String validarToken(String tokenJWT) {
        Algorithm algorithm = Algorithm.HMAC256(token);
        try {
            return JWT.require(algorithm)
                    .withIssuer("demo")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTCreationException e){
            System.out.println(tokenJWT + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
