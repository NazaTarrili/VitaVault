package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.BillingDetail;
import com.vitavault.vitavault.model.input.InputBillingDetail;
import com.vitavault.vitavault.service.billingDetail.IBillingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class BillingDetailResource {
    @Autowired
    private IBillingDetailService service;

    //Queries
    @QueryMapping
    public List<BillingDetail> getAllBillingDetail() {
        return service.getAll();
    }

    @QueryMapping
    public BillingDetail getBillingDetail(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createBillingDetail(@Argument InputBillingDetail input) {
        service.create(input);
    }

    @MutationMapping
    public void updateBillingDetail(@Argument UUID id, @Argument InputBillingDetail input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteBillingDetail(@Argument UUID id) {
        service.delete(id);
    }
}
