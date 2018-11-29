package com.example.dataindexer.frontend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserRemoteService {
    @Value("${dataindexer.userservice.url}")
    private String userServiceUrl;
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;

    public Optional<User> findUser(String username) {
        User user = restTemplate.getForObject(userServiceUrl + "getUserByName/" + username, User.class);
        return Optional.ofNullable(user);
    }

    public User registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity(userServiceUrl + "create", user, User.class);

        return userResponseEntity.getBody();
    }
}
