package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.input.InputState;
import com.vitavault.vitavault.service.state.IStateService;
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
public class StateResource {
    @Autowired
    private IStateService service;

    @Autowired
    private CustomResponses responses;
    
    //Queries
    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllState() {
        return responses.founded(service.getAll());
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getState(@Argument UUID id) {
        return responses.founded(service.getByID(id));
    }
    
    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createState(@Argument InputState input) {
        service.create(input);
        return responses.created();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updateState(@Argument UUID id, @Argument InputState input) {
        service.update(id, input);
        return responses.updated();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deleteState(@Argument UUID id) {
        service.delete(id);
        return responses.deleted();
    }
}
