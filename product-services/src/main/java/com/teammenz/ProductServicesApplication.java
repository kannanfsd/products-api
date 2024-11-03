package com.teammenz;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableAsync // Enables async processing
@OpenAPIDefinition(
		info = @Info(
				title = "TM Panel-Task REST API Documentation",
				description = "TM Panel task REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Marikannan Rajendran",
						email = "marikannan.cvp@gmail.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.tm.com/panel-task/api"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Products Services REST API Documentation",
				url = "https://tm.com/swagger-ui/index.html"
		)
)
public class ProductServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServicesApplication.class, args);
	}

}
