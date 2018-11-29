package com.example.dataindexer.frontend;

import com.example.dataindexer.frontend.user.UserRemoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontendApplication.class, args);
    }

    @Bean
    CommandLineRunner initApp(UserRemoteService userRemoteService) {
        return args -> {
            userRemoteService.registerUser("admin", "admin");
        };
    }
}
