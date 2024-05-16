package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Specialty;
import com.vitavault.vitavault.model.input.InputSpecialty;
import com.vitavault.vitavault.service.specialty.ISpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class SpecialtyResource {
    @Autowired
    private ISpecialtyService service;
    
    //Queries
    @QueryMapping
    public List<Specialty> getAllSpecialty() {
        return service.getAll();
    }

    @QueryMapping
    public Specialty getSpecialty(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createSpecialty(@Argument InputSpecialty input) {
        service.create(input);
    }

    @MutationMapping
    public void updateSpecialty(@Argument UUID id, @Argument InputSpecialty input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteSpecialty(@Argument UUID id) {
        service.delete(id);
    }
}
