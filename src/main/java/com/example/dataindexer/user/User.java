package com.example.dataindexer.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class User {
    private @Length(min = 5) String firstName;
    private String lastName;
}
