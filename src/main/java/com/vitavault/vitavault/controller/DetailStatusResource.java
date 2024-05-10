package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.input.InputDetailStatus;
import com.vitavault.vitavault.service.status.detail.IDetailStatusService;
import com.vitavault.vitavault.util.responses.CustomResponses;
import com.vitavault.vitavault.util.responses.ResponseFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.UUID;


@Controller
public class DetailStatusResource {
    @Autowired
    private IDetailStatusService service;

    @Autowired
    private CustomResponses responses;

    //Queries
    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllDetailStatus() {
        return responses.founded(service.getAll());
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getDetailStatus(@Argument UUID id) {
        return responses.founded(service.getByID(id));
    }

    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createDetailStatus(@Argument InputDetailStatus input) {
        service.create(input);
        return responses.created();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updateDetailStatus(@Argument UUID id, @Argument InputDetailStatus input) {
        service.update(id, input);
        return responses.updated();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deleteDetailStatus(@Argument UUID id) {
        service.delete(id);
        return responses.deleted();
    }
}
