package br.com.jhonny_azevedo.rest_api.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.service.Contact;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//    private Contact contact() {
//        return new Contact(
//                "Jhonny Azevedo",
//                "http://www.seusite.com.br/",
//                "jhonny.azevedo@gmail.com"
//        );
//    }
//
//    private ApiInfoBuilder apiDescription() {
//        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//
//        apiInfoBuilder.title("REST API")
//                .description("API para gerenciamento de usuários")
//                .version("1.0.0")
//                .termsOfServiceUrl("Termo de uso: Open source")
//                .license("Apache License Version 2.0")
//                .licenseUrl("http://www.seusite.com.br/")
//                .contact(this.contact());
//
//        return  apiInfoBuilder;
//    }
//
//    @Bean
//    public Docket apiDetails() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("br.com.jhonny_azevedo.rest_api.controllers"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(this.apiDescription().build())
//                .consumes(new HashSet<String>(Arrays.asList("application/json")))
//                .produces(new HashSet<String>(Arrays.asList("application/json")));
//    }
}
