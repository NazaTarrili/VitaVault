package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.DetailStatus;
import com.vitavault.vitavault.model.input.InputDetailStatus;
import com.vitavault.vitavault.service.status.detail.IDetailStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class DetailStatusResource {
    @Autowired
    private IDetailStatusService service;

    //Queries
    @QueryMapping
    public List<DetailStatus> getAllDetailStatus() {
        return service.getAll();
    }

    @QueryMapping
    public DetailStatus getDetailStatus(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createDetailStatus(@Argument InputDetailStatus input) {
        service.create(input);
    }

    @MutationMapping
    public void updateDetailStatus(@Argument UUID id, @Argument InputDetailStatus input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteDetailStatus(@Argument UUID id) {
        service.delete(id);
    }
}
