package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Street;
import com.vitavault.vitavault.model.input.InputStreet;
import com.vitavault.vitavault.service.street.IStreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class StreetResource {
    @Autowired
    private IStreetService service;
    
    //Queries
    @QueryMapping
    public List<Street> getAllStreet() {
        return service.getAll();
    }

    @QueryMapping
    public Street getStreet(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createStreet(@Argument InputStreet input) {
        service.create(input);
    }

    @MutationMapping
    public void updateStreet(@Argument UUID id, @Argument InputStreet input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteStreet(@Argument UUID id) {
        service.delete(id);
    }
}
