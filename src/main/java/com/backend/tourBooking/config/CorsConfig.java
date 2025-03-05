package com.backend.tourBooking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("Configuración CORS aplicada"); 
        registry.addMapping("/api/**") // Aplica a todas las rutas que empiezan con /api/
                .allowedOrigins("http://localhost:5173") // Permite solicitudes desde http://localhost:5173
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite estos métodos HTTP
                .allowedHeaders("*"); // Permite todas las cabeceras
    }
}
