package com.global.all4ocean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
@EnableCaching
@OpenAPIDefinition(
		info = @Info(
				title = "All 4 Ocean",
				summary = "API do App All4Ocean",
				description = "Uma rede social que visa conectar ongs e seus projetos com possiveis voluntarios",
				version = "1.0.0",
				contact = @Contact(name = "Julia Nery", email = "suporte@all4ocean.com")
		)
)
public class All4oceanApplication {

	public static void main(String[] args) {
		SpringApplication.run(All4oceanApplication.class, args);
	}

}
