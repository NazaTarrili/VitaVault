package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.CenterType;
import com.vitavault.vitavault.model.input.InputCenterType;
import com.vitavault.vitavault.service.type.center.ICenterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class CenterTypeResource {
    @Autowired
    private ICenterTypeService service;

    //Queries
    @QueryMapping
    public List<CenterType> getAllCenterType() {
        return service.getAll();
    }

    @QueryMapping
    public CenterType getCenterType(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createCenterType(@Argument InputCenterType input) {
        service.create(input);
    }

    @MutationMapping
    public void updateCenterType(@Argument UUID id, @Argument InputCenterType input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteCenterType(@Argument UUID id) {
        service.delete(id);
    }
}
