package com.portafolio.facturacion.configuracion;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Facturación")   // <-- Acá pongo el nombre de mi app
                        .version("1.0")
                        .description("API de Facturación")
                );
    }

}
