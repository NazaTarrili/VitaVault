package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.SubscriptionPlan;
import com.vitavault.vitavault.model.input.InputSubscriptionPlan;
import com.vitavault.vitavault.service.subscriptionPlan.ISubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class SubscriptionPlanResource {
    @Autowired
    private ISubscriptionPlanService service;
    
    //Queries
    @QueryMapping
    public List<SubscriptionPlan> getAllSubscriptionPlan() {
        return service.getAll();
    }

    @QueryMapping
    public SubscriptionPlan getSubscriptionPlan(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createSubscriptionPlan(@Argument InputSubscriptionPlan input) {
        service.create(input);
    }

    @MutationMapping
    public void updateSubscriptionPlan(@Argument UUID id, @Argument InputSubscriptionPlan input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteSubscriptionPlan(@Argument UUID id) {
        service.delete(id);
    }
}
