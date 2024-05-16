package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Bed;
import com.vitavault.vitavault.model.input.InputBed;
import com.vitavault.vitavault.service.bed.IBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class BedResource {
    @Autowired
    private IBedService service;

    //Queries
    @QueryMapping
    public List<Bed> getAllBed() {
        return service.getAll();
    }

    @QueryMapping
    public Bed getBed(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createBed(@Argument InputBed input) {
        service.create(input);
    }

    @MutationMapping
    public void updateBed(@Argument UUID id, @Argument InputBed input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteBed(@Argument UUID id) {
        service.delete(id);
    }
}
