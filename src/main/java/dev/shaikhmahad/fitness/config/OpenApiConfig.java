package dev.shaikhmahad.fitness.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Fitness Tracker Enterprise API")
                        .description("Backend REST API for tracking user fitness activities, generating recommendations, and managing role-based access.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Shaikh Mahad")
                                .url("https://shaikhmahad.vercel.app")));
    }
}