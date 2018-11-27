package com.example.dataindexer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataIndexerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataIndexerApplication.class, args);
    }

    @Bean
    CommandLineRunner startup() {
        return args -> {
        };
    }
}
