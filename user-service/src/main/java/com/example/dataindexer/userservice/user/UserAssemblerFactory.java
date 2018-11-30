package com.example.dataindexer.userservice.user;

import com.example.dataindexer.commons.assembler.Assembler;
import com.example.dataindexer.userservice.user.model.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class UserAssemblerFactory implements FactoryBean<UserAssemblerFactory.UserAssembler> {

    @Override
    public UserAssembler getObject() throws Exception {
        return new UserAssembler();
    }

    @Override
    public Class<?> getObjectType() {
        return UserAssembler.class;
    }

    public static class UserAssembler implements Assembler<UserDTO, User> {
        @Override
        public User assemble(UserDTO userDTO) {
            User user = new User();
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            return user;
        }
    }
}
