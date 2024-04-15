package com.etz.teamcrud.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI(){
        //.info(apiInfo());
        //addSecurity(openAPI);
        return new OpenAPI();
    }
}





