package com.example.estudosiniciais.estudos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringdocConfig {
  @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
        .info(new Info().title("API Restful com Documentação")
	              .description("API Restful utilizando Springdoc para documentação.")
	              .version("1.0.0")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	              .externalDocs(new ExternalDocumentation()
                .url("https://github.com/nathalyapereira")               
                );

    }

}
