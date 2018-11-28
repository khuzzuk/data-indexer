package com.example.dataindexer.userservice.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDTO {
    private @Length(min = 5) String firstName;
    private String lastName;
}
