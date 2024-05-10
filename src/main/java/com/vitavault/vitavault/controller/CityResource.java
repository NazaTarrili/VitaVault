package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.input.InputCity;
import com.vitavault.vitavault.service.city.ICityService;
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
public class CityResource {
    @Autowired
    private ICityService service;

    @Autowired
    private CustomResponses responses;

    //Queries
    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllCity() {
        return responses.founded(service.getAll());
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getCity(@Argument UUID id) {
        return responses.founded(service.getByID(id));
    }

    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createCity(@Argument InputCity input) {
        service.create(input);
        return responses.created();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updateCity(@Argument UUID id, @Argument InputCity input) {
        service.update(id, input);
        return responses.updated();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deleteCity(@Argument UUID id) {
        service.delete(id);
        return responses.deleted();
    }
}
