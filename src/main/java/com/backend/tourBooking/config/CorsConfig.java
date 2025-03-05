package com.backend.tourBooking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        System.out.println("Configuración CORS aplicada");
//        registry.addMapping("/api/**") // Aplica a todas las rutas que empiezan con /api/
//                .allowedOrigins("http://localhost:5173") // Permite solicitudes desde http://localhost:5173
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite estos métodos HTTP
//                .allowedHeaders("*"); // Permite todas las cabeceras
//    }
//}

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