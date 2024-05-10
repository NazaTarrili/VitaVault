package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.input.InputDeliveryNoteType;
import com.vitavault.vitavault.service.type.deliveryNote.IDeliveryNoteTypeService;
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
public class DeliveryNoteTypeResource {
    @Autowired
    private IDeliveryNoteTypeService service;

    @Autowired
    private CustomResponses responses;

    //Queries
    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllDeliveryNoteType() {
        return responses.founded(service.getAll());
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getDeliveryNoteType(@Argument UUID id) {
        return responses.founded(service.getByID(id));
    }

    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createDeliveryNoteType(@Argument InputDeliveryNoteType input) {
        service.create(input);
        return responses.created();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updateDeliveryNoteType(@Argument UUID id, @Argument InputDeliveryNoteType input) {
        service.update(id, input);
        return responses.updated();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deleteDeliveryNoteType(@Argument UUID id) {
        service.delete(id);
        return responses.deleted();
    }
}
