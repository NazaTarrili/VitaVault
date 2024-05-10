package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.input.InputPeriodicity;
import com.vitavault.vitavault.service.periodicity.IPeriodicityService;
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
public class PeriodicityResource {
    @Autowired
    private IPeriodicityService service;

    @Autowired
    private CustomResponses responses;
    
    //Queries
    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllPeriodicity() {
        return responses.founded(service.getAll());
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getPeriodicity(@Argument UUID id) {
        return responses.founded(service.getByID(id));
    }
    
    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createPeriodicity(@Argument InputPeriodicity input) {
        service.create(input);
        return responses.created();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updatePeriodicity(@Argument UUID id, @Argument InputPeriodicity input) {
        service.update(id, input);
        return responses.updated();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deletePeriodicity(@Argument UUID id) {
        service.delete(id);
        return responses.deleted();
    }
}
