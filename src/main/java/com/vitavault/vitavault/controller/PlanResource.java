package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Plan;
import com.vitavault.vitavault.model.input.InputPlan;
import com.vitavault.vitavault.service.plan.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class PlanResource {
    @Autowired
    private IPlanService service;
    
    //Queries
    @QueryMapping
    public List<Plan> getAllPlan() {
        return service.getAll();
    }

    @QueryMapping
    public Plan getPlan(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createPlan(@Argument InputPlan input) {
        service.create(input);
    }

    @MutationMapping
    public void updatePlan(@Argument UUID id, @Argument InputPlan input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deletePlan(@Argument UUID id) {
        service.delete(id);
    }
}
