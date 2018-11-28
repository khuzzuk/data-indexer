package com.example.dataindexer.userservice.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("user")
@Slf4j
public class UserRemoteServiceController {
    @Value("${indexer.property:property}")
    String myProperty;

    @GetMapping("read")
    public User getUser(@RequestParam(name = "id", required = false) Optional<Long> id) {
        User user = new User();
        user.setFirstName("First name " + id.orElse(0L));
        user.setLastName("Last name");
        return user;
    }

    @PostMapping("create")
    public User createUser(@RequestBody @Valid User user) {
        System.out.println(user);
        return user;
    }

    @org.springframework.web.bind.annotation.GetMapping(
            path = "createOrUpdate",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User createOrUpdate(@RequestParam(name = "user") User user, HttpServletRequest request) {
        log.warn(request.getHeader("Content-Type"));
        return user;
    }
}
