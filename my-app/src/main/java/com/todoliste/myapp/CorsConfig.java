package com.todoliste.myapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Spécifiez le chemin d'accès de l'API que vous souhaitez autoriser
                .allowedOrigins("*") // Autorisez l'origine http://localhost:8082
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
        //.allowCredentials(true);
    }
}
