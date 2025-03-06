package com.backend.tourBooking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Value("${front.url}")
    private String frontendUrl;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin(frontendUrl); // Permite todos los orígenes.
        config.addAllowedMethod("*"); // Permite todos los métodos HTTP (GET, POST, etc.)
        config.addAllowedHeader("*"); // Permite todos los encabezados.
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}