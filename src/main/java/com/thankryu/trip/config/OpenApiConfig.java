package com.thankryu.trip.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI(@Value("v1.0") String appVersion) {

        Info info = new Info().title("trips API Docs").version(appVersion)
                .description("Spring Boot를 이용한 trips API Docs 입니다.")
                .termsOfService("https://thankryu.iptime.org/swagger-ui")
                .contact(new Contact().name("thankryu").url("https://github.com/thankryu").email("thankryu@gmail.com"));


        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}