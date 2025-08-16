package ru.alex.burdovitsin.example01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Example01Application {

    public static void main(String[] args) {
        SpringApplication.run(Example01Application.class, args);
    }

}
