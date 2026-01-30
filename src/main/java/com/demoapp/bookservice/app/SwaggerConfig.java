package com.demoapp.bookservice.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public CustomAnnotationSwaggerPlugin commonPathVariableOperationBuilderPlugin() {
        return new CustomAnnotationSwaggerPlugin();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/**"))
                .apis(RequestHandlerSelectors.basePackage("com.demoapp.bookservice.app"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "DEMO API",
                "DEMO API Swagger Doc.",
                "1.0",
                "www.demo.com/terms_of_service",
                new Contact("ContactName", "www.demoapp.com", "admin@demoapp.com"),
                "Custom licence", "www.demoapp.com/licence", Collections.emptyList());
    }
}