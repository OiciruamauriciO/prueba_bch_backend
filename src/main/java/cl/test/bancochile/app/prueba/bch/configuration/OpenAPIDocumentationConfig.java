package cl.test.bancochile.app.prueba.bch.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Configuration
public class OpenAPIDocumentationConfig {

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("API Rest ms-prueba-bch").description("API Rest ms-prueba-bch")
						.version("v1.0").license(new License().name("Apache 2.0").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation().description("Documentacion"));
	}
}
