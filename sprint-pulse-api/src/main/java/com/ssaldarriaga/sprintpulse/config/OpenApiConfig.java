package com.ssaldarriaga.sprintpulse.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
            contact = @Contact(
                    name = "Sebastian Saldarriaga",
                    email = "ssaldarriaga.cardona@udea.edu.co"
            ),
            description = "OpenAPI definition for Sprint Pulse API",
            title = "OpenAPI Specification - Sprint Pulse",
            version = "1.0.0",
            license = @License(
                    name = "Licence name",
                    url = "https://some-url.com"
            ),
            termsOfService = "https://some-url.com"
    ),
        servers = {
            @Server(
                    description = "Local Environment",
                    url = "http://localhost:8088/api/v1"
            ), @Server(
                    description = "Production Environment",
                    url = "https://some-fake-url.com/api/v1"
            )
        },
        security = {
            @SecurityRequirement(
                    name = "bearerAuth"
            )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "Bearer Token Authentication",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
