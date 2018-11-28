package com.example.dataindexer.userservice.contact;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {
    @SequenceGenerator(name = "address_id_gen", sequenceName = "address_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_gen")
    @Id
    private Long id;
    private String city;
    private String street;
    private String house;
    private String flat;
    private String zipCode;
}
