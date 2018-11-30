package com.example.dataindexer.userservice.user;

import com.example.dataindexer.commons.assembler.Assembler;
import com.example.dataindexer.userservice.user.model.Role;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class RoleDTOAssemblerFactoryBean implements FactoryBean<RoleDTOAssemblerFactoryBean.RoleDTOAssembler> {
    @Override
    public RoleDTOAssembler getObject() throws Exception {
        return new RoleDTOAssembler();
    }

    @Override
    public Class<?> getObjectType() {
        return RoleDTOAssembler.class;
    }

    public static class RoleDTOAssembler implements Assembler<Role, RoleDTO> {

        @Override
        public RoleDTO assemble(Role role) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setName(role.getName());
            return roleDTO;
        }
    }
}
