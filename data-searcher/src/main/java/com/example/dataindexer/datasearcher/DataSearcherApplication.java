package com.example.dataindexer.datasearcher;

import com.example.dataindexer.datasearcher.model.DoorsDocument;
import com.example.dataindexer.datasearcher.model.Person;
import com.example.dataindexer.datasearcher.repo.DoorsDocumentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

@SpringBootApplication
public class DataSearcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataSearcherApplication.class, args);
    }

    @Bean
    CommandLineRunner generateData(DoorsDocumentRepository doorsDocumentRepository) {
        return args -> {
            for (int i = 0; i < 100; i++) {
                doorsDocumentRepository.save(generate());
            }
        };
    }

    private static int counter;

    private static DoorsDocument generate() {
        DoorsDocument document = new DoorsDocument();
        document.setDocumentNumber(String.valueOf(counter++));
        document.setDocumentType("BASIC_TYPE");
        document.setDocumentVersion(String.valueOf(counter++));
        document.setCreator(createPerson());
        document.setReleasedOn(Timestamp.from(Instant.now()));
        document.setInvolved(Set.of(createPerson(), createPerson()));
        return document;
    }

    private static Person createPerson() {
        Person person = new Person();
        person.setUserId(String.valueOf(counter++));
        return person;
    }
}
