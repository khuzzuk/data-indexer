package com.example.dataindexer.userservice.user;

import com.example.dataindexer.commons.assembler.Assembler;
import com.example.dataindexer.userservice.user.model.Role;
import com.example.dataindexer.userservice.user.model.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDTOAssemblerFactoryBean implements FactoryBean<UserDTOAssemblerFactoryBean.UserDTOAssembler> {
    @Autowired
    private Assembler<Role, RoleDTO> roleDTOAssembler;

    @Override
    public UserDTOAssembler getObject() {
        return new UserDTOAssembler();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDTOAssembler.class;
    }

    public class UserDTOAssembler implements Assembler<User, UserDTO> {
        @Override
        public UserDTO assemble(User user) {
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setUsername(user.getUsername());
            userDTO.setPassword(user.getPassword());
            userDTO.setRoles(roleDTOAssembler.assembleToSet(user.getRoles()));
            return userDTO;
        }
    }
}
