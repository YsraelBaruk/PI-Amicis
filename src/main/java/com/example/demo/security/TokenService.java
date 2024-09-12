package com.example.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String token;

    private String gerarToken;

    public String gerarToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(token);
            return JWT.create()
                    .withIssuer("demo")
                    .withSubject(user.getEmail())
                    .withExpiresAt()
        }
    }

    public String getSubject() {
    }
}
