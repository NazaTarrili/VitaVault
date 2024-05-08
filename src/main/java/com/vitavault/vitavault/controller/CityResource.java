package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.City;
import com.vitavault.vitavault.service.city.ICityService;
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
public class CityResource {
    @Autowired
    private ICityService service;

    @Autowired
    private CustomResponses responses;

    //Queries
    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllCity() {
        try {
            return responses.founded(service.getAll());
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getCity(@Argument UUID id) {
        try {
            return responses.founded(service.getByID(id));
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createCity(@Argument City input) {
        try {
            if (service.create(input)) return responses.created();

            return responses.badRequest();
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updateCity(@Argument UUID id, @Argument City input) {
        try {
            if (service.update(id, input)) return responses.updated();

            return responses.badRequest();
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deleteCity(@Argument UUID id) {
        try {
            if(service.delete(id)) return responses.deleted();

            return responses.notFounded();
        } catch (Exception e) {
            return responses.error(e);
        }
    }
}
