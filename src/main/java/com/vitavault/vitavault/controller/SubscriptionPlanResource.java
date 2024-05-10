package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.input.InputSubscriptionPlan;
import com.vitavault.vitavault.service.subscriptionPlan.ISubscriptionPlanService;
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
public class SubscriptionPlanResource {
    @Autowired
    private ISubscriptionPlanService service;

    @Autowired
    private CustomResponses responses;
    
    //Queries
    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllSubscriptionPlan() {
        return responses.founded(service.getAll());
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getSubscriptionPlan(@Argument UUID id) {
        return responses.founded(service.getByID(id));
    }
    
    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createSubscriptionPlan(@Argument InputSubscriptionPlan input) {
        service.create(input);
        return responses.created();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updateSubscriptionPlan(@Argument UUID id, @Argument InputSubscriptionPlan input) {
        service.update(id, input);
        return responses.updated();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deleteSubscriptionPlan(@Argument UUID id) {
        service.delete(id);
        return responses.deleted();
    }
}
