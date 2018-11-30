package com.example.dataindexer.datasearcher.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ad_person")
public class Person {
    @SequenceGenerator(name = "person_id_gen", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_gen")
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String userId;
}
