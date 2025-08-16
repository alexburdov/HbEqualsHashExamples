package ru.alex.burdovitsin.example00;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Example00Application {

    public static void main(String[] args) {
        SpringApplication.run(Example00Application.class, args);
    }

}
