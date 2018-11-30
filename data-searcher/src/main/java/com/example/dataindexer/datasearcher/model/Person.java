package com.example.dataindexer.datasearcher.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ad_person")
public class Person {
    private String firstName;
    private String secondName;
    private String userId;
}
