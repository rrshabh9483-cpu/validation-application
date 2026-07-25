package com.spring_validation.validation.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Value("${server.port:9292}")
    private int serverPort;

    @Bean
    public OpenAPI validationOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User Validation API")
                        .description("REST API for creating and fetching users")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Spring Validation")
                                .email("support@example.com")))
                .addServersItem(new Server()
                        .url("http://localhost:" + serverPort)
                        .description("Local development server"));
    }
}
