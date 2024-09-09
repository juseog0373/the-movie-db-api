package com.ecocow.themovieapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TheMovieApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheMovieApiApplication.class, args);
    }

}
