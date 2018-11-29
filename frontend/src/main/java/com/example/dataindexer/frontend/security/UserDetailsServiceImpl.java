package com.example.dataindexer.frontend.security;

import com.example.dataindexer.commons.assembler.Assembler;
import com.example.dataindexer.frontend.user.User;
import com.example.dataindexer.frontend.user.UserRemoteService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRemoteService userRemoteService;
    private Assembler<User, UserDetails> userDetailsAssembler;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRemoteService.findUser(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return userDetailsAssembler.assemble(user);
    }
}
