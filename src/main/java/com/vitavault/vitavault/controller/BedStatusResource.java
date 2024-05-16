package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.BedStatus;
import com.vitavault.vitavault.model.input.InputBedStatus;
import com.vitavault.vitavault.service.status.bed.IBedStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class BedStatusResource {
    @Autowired
    private IBedStatusService service;

    //Queries
    @QueryMapping
    public List<BedStatus> getAllBedStatus() {
        return service.getAll();
    }

    @QueryMapping
    public BedStatus getBedStatus(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createBedStatus(@Argument InputBedStatus input) {
        service.create(input);
    }

    @MutationMapping
    public void updateBedStatus(@Argument UUID id, @Argument InputBedStatus input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteBedStatus(@Argument UUID id) {
        service.delete(id);
    }
}
