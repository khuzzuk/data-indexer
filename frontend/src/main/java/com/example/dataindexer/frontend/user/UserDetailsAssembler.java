package com.example.dataindexer.frontend.user;

import com.example.dataindexer.commons.assembler.Assembler;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsAssembler implements Assembler<User, UserDetails> {
    @Override
    public UserDetails assemble(User user) {
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), List.of()
        );
        return userDetails;
    }
}
