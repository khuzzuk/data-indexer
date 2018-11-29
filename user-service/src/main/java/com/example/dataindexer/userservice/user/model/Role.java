package com.example.dataindexer.userservice.user.model;

import lombok.Data;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Data
@Entity
public class Role {
    @SequenceGenerator(name = "role_id_gen", sequenceName = "role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_gen")
    @Id
    private Long id;
    @NaturalId
    private @Length(max = 15, min = 3) String name;
}
