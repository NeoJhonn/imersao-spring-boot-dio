package br.com.jhonny_azevedo.rest_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Congigurações do Swagger, documentação
@OpenAPIDefinition(
		info = @Info(
				title = "REST API",
				description = "API para gerenciamento de usuários",
				version = "1.0",
				termsOfService = "Termo de uso: Open source"
		)
)
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
