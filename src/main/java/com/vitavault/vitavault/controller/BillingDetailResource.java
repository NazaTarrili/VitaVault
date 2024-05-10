package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.input.InputBillingDetail;
import com.vitavault.vitavault.service.billingDetail.IBillingDetailService;
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
public class BillingDetailResource {
    @Autowired
    private IBillingDetailService service;

    @Autowired
    private CustomResponses responses;

    //Queries
    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllBillingDetail() {
        return responses.founded(service.getAll());
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getBillingDetail(@Argument UUID id) {
        return responses.founded(service.getByID(id));
    }

    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createBillingDetail(@Argument InputBillingDetail input) {
        service.create(input);
        return responses.created();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updateBillingDetail(@Argument UUID id, @Argument InputBillingDetail input) {
        service.update(id, input);
        return responses.updated();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deleteBillingDetail(@Argument UUID id) {
        service.delete(id);
        return responses.deleted();
    }
}
