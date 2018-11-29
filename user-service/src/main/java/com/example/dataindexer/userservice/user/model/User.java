package com.example.dataindexer.userservice.user.model;

import com.example.dataindexer.userservice.contact.Address;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class User {
    @SequenceGenerator(name = "user_id_gen", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
    @Id
    private Long id;
    private String username;
    private String password;
    @ManyToMany
    private @NotEmpty Set<Role> roles;

    private String firstName;
    private String lastName;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses;
}
