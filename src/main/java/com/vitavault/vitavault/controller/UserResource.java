package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.User;
import com.vitavault.vitavault.model.input.InputUser;
import com.vitavault.vitavault.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class UserResource {
    @Autowired
    private IUserService service;
    
    //Queries
    @QueryMapping
    public List<User> getAllUser() {
        return service.getAll();
    }

    @QueryMapping
    public User getUser(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createUser(@Argument InputUser input) {
        service.create(input);
    }

    @MutationMapping
    public void updateUser(@Argument UUID id, @Argument InputUser input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteUser(@Argument UUID id) {
        service.delete(id);
    }
}
