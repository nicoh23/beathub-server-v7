package nocountry.beathub.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SwaggerConfig {

    /**
     * Configurar el bean de Open API para cargar la informacion basica del proyecto
     * @return open api info
     */
    @Bean
    public OpenAPI themeparkOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BeatHub spring boot 3")
                        .description("Aplicación de API Rest para el crud de BeatHub")
                        .version("v1.0.0")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

    }

}
