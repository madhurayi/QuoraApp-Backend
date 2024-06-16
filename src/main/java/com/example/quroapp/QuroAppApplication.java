package com.example.quroapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuroAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuroAppApplication.class, args);
    }

}
