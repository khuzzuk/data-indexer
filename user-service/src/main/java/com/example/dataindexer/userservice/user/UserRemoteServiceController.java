package com.example.dataindexer.userservice.user;

import com.example.dataindexer.userservice.assembler.Assembler;
import com.example.dataindexer.userservice.user.model.User;
import com.example.dataindexer.userservice.user.model.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("user")
@Slf4j
public class UserRemoteServiceController {
    private Assembler<User, UserDTO> userDTOAssembler;
    private UserRepository userRepository;

    @GetMapping("read")
    public UserDTO getUser(@RequestParam(name = "id", required = false) Optional<Long> id) {
        User user = userRepository.getById(id.orElseThrow(NoResultException::new));
        return userDTOAssembler.assemble(user);
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
