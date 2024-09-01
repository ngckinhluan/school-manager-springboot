package com.naul2k.schoolmanager.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                contact = @Contact(
                        name = "Naul2k",
                        email = "luantnk2907@gmail.com"
                ),
                title = "School Manager API",
                version = "1.0",
                description = "API for managing courses and lecturers",
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local ENV"
                )
        }

)
@SecurityScheme(name = "bearerAuth", 
        description = "JWT auth description", 
        scheme = "bearer", 
        type = SecuritySchemeType.HTTP, 
        bearerFormat = "JWT", 
        in = SecuritySchemeIn.HEADER)
public class OpenApiConfig {

}
