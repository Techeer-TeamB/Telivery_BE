package com.telivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TeliveryApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeliveryApiApplication.class, args);
    }
}
