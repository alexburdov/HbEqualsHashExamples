package ru.alex.burdovitsin.example02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Example02Application {

    public static void main(String[] args) {
        SpringApplication.run(Example02Application.class, args);
    }

}
