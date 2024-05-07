package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Address;
import com.vitavault.vitavault.service.address.IAddressService;
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
public class AddressController {
    @Autowired
    private IAddressService service;

    @Autowired
    private CustomResponses responses;

    @MutationMapping
    public ResponseEntity<ResponseFormatter> createAddress(@Argument Address entity) {
        try {
            if (service.create(entity)) return responses.created();

            return responses.badRequest();
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllAddress() {
        try {
            return responses.founded(service.getAll());
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAddressByID(@Argument UUID id) {
        try {
            return responses.founded(service.getByID(id));
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updateAddress(@Argument UUID id, @Argument Address entity) {
        try {
            if (service.update(id, entity)) return responses.updated();

            return responses.badRequest();
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deleteAddress(@Argument UUID id) {
        try {
            if(service.delete(id)) return responses.deleted();

            return responses.notFounded();
        } catch (Exception e) {
            return responses.error(e);
        }
    }
}
