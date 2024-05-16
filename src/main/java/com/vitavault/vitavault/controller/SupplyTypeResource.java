package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.SupplyType;
import com.vitavault.vitavault.model.input.InputSupplyType;
import com.vitavault.vitavault.service.type.supply.ISupplyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class SupplyTypeResource {
    @Autowired
    private ISupplyTypeService service;
    
    //Queries
    @QueryMapping
    public List<SupplyType> getAllSupplyType() {
        return service.getAll();
    }

    @QueryMapping
    public SupplyType getSupplyType(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createSupplyType(@Argument InputSupplyType input) {
        service.create(input);
    }

    @MutationMapping
    public void updateSupplyType(@Argument UUID id, @Argument InputSupplyType input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteSupplyType(@Argument UUID id) {
        service.delete(id);
    }
}
