package com.example.dataindexer.userservice.user.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @SequenceGenerator(name = "user_id_gen", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}
