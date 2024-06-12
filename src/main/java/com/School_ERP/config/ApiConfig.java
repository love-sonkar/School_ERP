package com.School_ERP.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info=@Info(
                title = "Bus API",
                description = "Operation on Bus",
                summary = "This is Bus API",
                termsOfService = "Term & condition",
                contact = @Contact(
                        name = "Ashutosh",
                        email = "ashutoshchoukade@gmail.com"
                ),
                license = @License(
                        name = "License number"
                ),
                version = "v1"
        ),
        servers = {
                @Server(
                        description = "Student",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Test",
                        url = "http://localhost:8080"
                ),
        }
        )
public class ApiConfig {
}
