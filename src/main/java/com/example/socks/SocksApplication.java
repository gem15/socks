package com.example.socks;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Socks API", version = "0.1", description = "Тестовое задание"))
public class SocksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocksApplication.class, args);
    }

}
