package com.yevhen_l.event.service.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yevhen_l.event.service", "com.yevhen_l.event.service.rest"})
@EntityScan("com.yevhen_l.event.service")
@EnableJpaRepositories("com.yevhen_l.event.service.impl.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

