package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Role;
import com.vitavault.vitavault.model.input.InputRole;
import com.vitavault.vitavault.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class RoleResource {
    @Autowired
    private IRoleService service;
    
    //Queries
    @QueryMapping
    public List<Role> getAllRole() {
        return service.getAll();
    }

    @QueryMapping
    public Role getRole(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createRole(@Argument InputRole input) {
        service.create(input);
    }

    @MutationMapping
    public void updateRole(@Argument UUID id, @Argument InputRole input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteRole(@Argument UUID id) {
        service.delete(id);
    }
}
