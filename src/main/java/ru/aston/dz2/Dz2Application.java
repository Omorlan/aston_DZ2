package ru.aston.dz2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("ru.aston.dz2.repository")
public class Dz2Application {

    public static void main(String[] args) {
        SpringApplication.run(Dz2Application.class, args);
    }

}
