package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.input.InputSupply;
import com.vitavault.vitavault.service.supply.ISupplyService;
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
public class SupplyResource {
    @Autowired
    private ISupplyService service;

    @Autowired
    private CustomResponses responses;
    
    //Queries
    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllSupply() {
        return responses.founded(service.getAll());
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getSupply(@Argument UUID id) {
        return responses.founded(service.getByID(id));
    }
    
    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createSupply(@Argument InputSupply input) {
        service.create(input);
        return responses.created();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updateSupply(@Argument UUID id, @Argument InputSupply input) {
        service.update(id, input);
        return responses.updated();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deleteSupply(@Argument UUID id) {
        service.delete(id);
        return responses.deleted();
    }
}
