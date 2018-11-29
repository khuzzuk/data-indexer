package com.example.dataindexer.userservice.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Data
public class UserDTO {
    private @Length(min = 5) String firstName;
    private String lastName;
    private String username;
    private String password;
    private Set<RoleDTO> roles;
}
