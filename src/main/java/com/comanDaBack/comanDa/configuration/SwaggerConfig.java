package com.comanDaBack.comanDa.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "API COMANDA", //nombre de la api
                description = "Comanda Backend es una aplicación monolítica diseñada para " +
                        "centralizar la gestión integral de un bar. Optimiza tanto la " +
                        "administración como la operación diaria del local, permitiendo una " +
                        "gestión eficiente de productos, menús, clientes y pedidos. Facilita " +
                        "especialmente a los mozos la toma rápida y organizada de pedidos desde la " +
                        "aplicación."
                ,
                version = "1.0",
                contact = @Contact( // la info de la empresa o la persona a cargo de la empresa
                        name = "Rosario Guardia",
                        email = "rlsgcode@gmail.com"
                )
        ),
        servers ={ @Server(
                url = "http://localhost:8080"
        )},
        security = @SecurityRequirement(
                name = "Security token"
        )
)
@SecurityScheme(
        name = "Security token",
        description = "Access token for my API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig { }
