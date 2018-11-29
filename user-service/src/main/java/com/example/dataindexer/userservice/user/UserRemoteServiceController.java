package com.example.dataindexer.userservice.user;

import com.example.dataindexer.userservice.assembler.Assembler;
import com.example.dataindexer.userservice.user.model.RoleRepository;
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
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("user")
@Slf4j
public class UserRemoteServiceController {
    private Assembler<User, UserDTO> userDTOAssembler;
    private Assembler<UserDTO, User> userAssembler;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @GetMapping("read")
    public UserDTO getUser(@RequestParam(name = "id", required = false) Optional<Long> id) {
        User user = userRepository.getById(id.orElseThrow(NoResultException::new));
        return userDTOAssembler.assemble(user);
    }

    @GetMapping("getUserByName/{username}")
    public UserDTO getUserByName(@PathVariable(name = "username") String username) {
        User user = userRepository.findByUsername(username).get();
        return userDTOAssembler.assemble(user);
    }

    @PostMapping("create")
    public UserDTO createUser(@RequestBody @Valid UserDTO userDTO) {
        User user = userAssembler.assemble(userDTO);
        user.setRoles(Set.of(roleRepository.findByName("ROLE_USER").get()));
        User persistedUser = userRepository.save(user);
        return userDTOAssembler.assemble(persistedUser);
    }

    @org.springframework.web.bind.annotation.GetMapping(
            path = "createOrUpdate",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserDTO createOrUpdate(@RequestParam(name = "userDTO") UserDTO userDTO, HttpServletRequest request) {
        log.warn(request.getHeader("Content-Type"));
        return userDTO;
    }
}
