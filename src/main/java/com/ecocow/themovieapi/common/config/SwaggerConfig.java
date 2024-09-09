package com.ecocow.themovieapi.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI swaggerApi() {
        Server server = new Server()
                .url("/")
                .description("Default Server url");
        io.swagger.v3.oas.models.info.Info info = new Info()
                .version("v1.0.0")
                .title("The Movie DB Backend API Documentation")
                .description("The Movie DB API feat. jskim");
        return new OpenAPI()
                .addServersItem(server)
                .info(info);
    }
}
