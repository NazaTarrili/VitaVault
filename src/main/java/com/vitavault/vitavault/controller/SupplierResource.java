package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Supplier;
import com.vitavault.vitavault.model.input.InputSupplier;
import com.vitavault.vitavault.service.supplier.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class SupplierResource {
    @Autowired
    private ISupplierService service;
    
    //Queries
    @QueryMapping
    public List<Supplier> getAllSupplier() {
        return service.getAll();
    }

    @QueryMapping
    public Supplier getSupplier(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createSupplier(@Argument InputSupplier input) {
        service.create(input);
    }

    @MutationMapping
    public void updateSupplier(@Argument UUID id, @Argument InputSupplier input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteSupplier(@Argument UUID id) {
        service.delete(id);
    }
}
