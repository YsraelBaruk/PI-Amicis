package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry
                        .addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("Authorization", "Content-Type", "Accept")
                        .allowedMethods("GET", "POST", "PUT", "OPTIONS", "PATCH");
            }
        };
    }
}