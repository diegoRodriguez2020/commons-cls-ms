package com.cls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan("com.*")
@ComponentScan(basePackages = "com.*")
public class MainApplication {
    @PostConstruct
    void started() {
        // Establecer la zona horaria por defecto a la zona horaria a Bogota
        TimeZone.setDefault(TimeZone.getTimeZone("America/Bogota"));
    }
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
