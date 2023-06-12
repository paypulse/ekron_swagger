package com.example.ekorn_admin_swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EkornAdminSwaggerApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EkornAdminSwaggerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EkornAdminSwaggerApplication.class);
    }

}
