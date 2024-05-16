package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Center;
import com.vitavault.vitavault.model.input.InputCenter;
import com.vitavault.vitavault.service.center.ICenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class CenterResource {
    @Autowired
    private ICenterService service;

    //Queries
    @QueryMapping
    public List<Center> getAllCenter() {
        return service.getAll();
    }

    @QueryMapping
    public Center getCenter(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createCenter(@Argument InputCenter input) {
        service.create(input);
    }

    @MutationMapping
    public void updateCenter(@Argument UUID id, @Argument InputCenter input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteCenter(@Argument UUID id) {
        service.delete(id);
    }
}
