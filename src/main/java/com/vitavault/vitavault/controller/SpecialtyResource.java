package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.input.InputSpecialty;
import com.vitavault.vitavault.service.specialty.ISpecialtyService;
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
public class SpecialtyResource {
    @Autowired
    private ISpecialtyService service;

    @Autowired
    private CustomResponses responses;
    
    //Queries
    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllSpecialty() {
        return responses.founded(service.getAll());
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getSpecialty(@Argument UUID id) {
        return responses.founded(service.getByID(id));
    }
    
    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createSpecialty(@Argument InputSpecialty input) {
        service.create(input);
        return responses.created();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updateSpecialty(@Argument UUID id, @Argument InputSpecialty input) {
        service.update(id, input);
        return responses.updated();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deleteSpecialty(@Argument UUID id) {
        service.delete(id);
        return responses.deleted();
    }
}
