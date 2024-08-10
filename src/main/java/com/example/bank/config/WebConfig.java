package com.example.bank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String[] ALLOWED_METHODS = {"GET", "POST", "PUT", "DELETE", "OPTIONS"};

    // Укажите все разрешенные домены
    private static final String[] ALLOWED_ORIGINS = {
            ///           "http://localhost:8080",
            "https://task-production-73fb.up.railway.app",
            "https://example.com" // Добавьте другие домены, если необходимо
    };

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(ALLOWED_ORIGINS)
                .allowedMethods(ALLOWED_METHODS)
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
