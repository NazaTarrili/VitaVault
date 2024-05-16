package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Periodicity;
import com.vitavault.vitavault.model.input.InputPeriodicity;
import com.vitavault.vitavault.service.periodicity.IPeriodicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class PeriodicityResource {
    @Autowired
    private IPeriodicityService service;
    
    //Queries
    @QueryMapping
    public List<Periodicity> getAllPeriodicity() {
        return service.getAll();
    }

    @QueryMapping
    public Periodicity getPeriodicity(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createPeriodicity(@Argument InputPeriodicity input) {
        service.create(input);
    }

    @MutationMapping
    public void updatePeriodicity(@Argument UUID id, @Argument InputPeriodicity input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deletePeriodicity(@Argument UUID id) {
        service.delete(id);
    }
}
