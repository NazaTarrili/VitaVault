package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Supply;
import com.vitavault.vitavault.model.input.InputSupply;
import com.vitavault.vitavault.service.supply.ISupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class SupplyResource {
    @Autowired
    private ISupplyService service;
    
    //Queries
    @QueryMapping
    public List<Supply> getAllSupply() {
        return service.getAll();
    }

    @QueryMapping
    public Supply getSupply(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createSupply(@Argument InputSupply input) {
        service.create(input);
    }

    @MutationMapping
    public void updateSupply(@Argument UUID id, @Argument InputSupply input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteSupply(@Argument UUID id) {
        service.delete(id);
    }
}
