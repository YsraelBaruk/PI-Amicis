package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
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
@EnableWebSecurity
public class SpringConfiguration {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(c -> c.disable())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(a -> {
                    //Login e Registro
                    a.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
                    a.requestMatchers(HttpMethod.POST, "/auth/register").permitAll();
                    //Para postar informações como cachorros, serviços e planos
                    a.requestMatchers(HttpMethod.POST, "/dog-config").hasRole("ADMIN");
                    a.requestMatchers(HttpMethod.POST, "/service-config").hasRole("ADMIN");
                    a.requestMatchers(HttpMethod.POST, "/plan-config").hasRole("ADMIN");
                    //Para alterar as informações como cachorro, serviços e plano
                    a.requestMatchers(HttpMethod.PUT, "/dog-config").hasRole("ADMIN");
                    a.requestMatchers(HttpMethod.PUT, "/service-config").hasRole("ADMIN");
                    a.requestMatchers(HttpMethod.PUT, "/plan-config").hasRole("ADMIN");
                    //documentação
//                    a.requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll();
                    a.anyRequest().authenticated();
                })
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
