package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Address;
import com.vitavault.vitavault.model.input.InputAddress;
import com.vitavault.vitavault.service.address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class AddressController {
    @Autowired
    private IAddressService service;

    //Queries
    @QueryMapping
    public List<Address> getAllAddress() {
        return service.getAll();
    }

    @QueryMapping
    public Address getAddress(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createAddress(@Argument InputAddress input) {
        service.create(input);
    }

    @MutationMapping
    public void updateAddress(@Argument UUID id, @Argument InputAddress input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteAddress(@Argument UUID id) {
        service.delete(id);
    }
}
