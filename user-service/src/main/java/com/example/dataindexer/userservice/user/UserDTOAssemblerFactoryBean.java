package com.example.dataindexer.userservice.user;

import com.example.dataindexer.userservice.assembler.Assembler;
import com.example.dataindexer.userservice.user.model.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class UserDTOAssemblerFactoryBean implements FactoryBean<UserDTOAssemblerFactoryBean.UserDTOAssembler> {
    @Override
    public UserDTOAssembler getObject() {
        return new UserDTOAssembler();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDTOAssembler.class;
    }

    public static class UserDTOAssembler implements Assembler<User, UserDTO> {
        @Override
        public UserDTO assemble(User user) {
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            return userDTO;
        }
    }
}
