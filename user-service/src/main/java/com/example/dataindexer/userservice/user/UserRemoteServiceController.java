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
    public UserDTO getUser(@RequestParam(name = "id", required = false) Optional<Long> id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("First name " + id.orElse(0L));
        userDTO.setLastName("Last name");
        return userDTO;
    }

    @PostMapping("create")
    public UserDTO createUser(@RequestBody @Valid UserDTO userDTO) {
        System.out.println(userDTO);
        return userDTO;
    }

    @org.springframework.web.bind.annotation.GetMapping(
            path = "createOrUpdate",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserDTO createOrUpdate(@RequestParam(name = "userDTO") UserDTO userDTO, HttpServletRequest request) {
        log.warn(request.getHeader("Content-Type"));
        return userDTO;
    }
}
