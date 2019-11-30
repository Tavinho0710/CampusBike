package com.greenbelly.metraz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    
    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:8081", "http://192.168.0.106:8081")
                        .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE")
//                        .allowCredentials(true)
//                        .allowedHeaders("Content-Type", "X-Token", "X-Content-Length")
//                        .exposedHeaders("Content-Type", "X-Token", "X-Content-Length")
                        .maxAge(3600);
            }
        };
    }
    
}
