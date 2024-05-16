package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Availability;
import com.vitavault.vitavault.model.input.InputAvailability;
import com.vitavault.vitavault.service.availability.IAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class AvailabilityResource {
    @Autowired
    private IAvailabilityService service;

    //Queries
    @QueryMapping
    public List<Availability> getAllAvailability() {
        return service.getAll();
    }

    @QueryMapping
    public Availability getAvailability(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createAvailability(@Argument InputAvailability input) {
        service.create(input);
    }

    @MutationMapping
    public void updateAvailability(@Argument UUID id, @Argument InputAvailability input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteAvailability(@Argument UUID id) {
        service.delete(id);
    }
}
