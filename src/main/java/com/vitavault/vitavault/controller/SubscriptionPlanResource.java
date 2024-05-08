package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.SubscriptionPlan;
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
        try {
            return responses.founded(service.getAll());
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getSubscriptionPlan(@Argument UUID id) {
        try {
            return responses.founded(service.getByID(id));
        } catch (Exception e) {
            return responses.error(e);
        }
    }
    
    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createSubscriptionPlan(@Argument SubscriptionPlan entity) {
        try {
            if (service.create(entity)) return responses.created();

            return responses.badRequest();
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updateSubscriptionPlan(@Argument UUID id, @Argument SubscriptionPlan entity) {
        try {
            if (service.update(id, entity)) return responses.updated();

            return responses.badRequest();
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deleteSubscriptionPlan(@Argument UUID id) {
        try {
            if(service.delete(id)) return responses.deleted();

            return responses.notFounded();
        } catch (Exception e) {
            return responses.error(e);
        }
    }
}
