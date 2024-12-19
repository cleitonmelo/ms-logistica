package br.com.techchalleng4.mslogistica;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API Logistica",
				description = "Tech Challeng 4 - FIAP 2024 - Grupo 18",
				version = "1.0.0"
		)
)
public class MslogisticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MslogisticaApplication.class, args);
	}

}
