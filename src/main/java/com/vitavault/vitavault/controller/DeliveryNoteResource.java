package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.input.InputDeliveryNote;
import com.vitavault.vitavault.service.deliveryNote.IDeliveryNoteService;
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
public class DeliveryNoteResource {
    @Autowired
    private IDeliveryNoteService service;

    @Autowired
    private CustomResponses responses;

    //Queries
    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllDeliveryNote() {
        return responses.founded(service.getAll());
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getDeliveryNote(@Argument UUID id) {
        return responses.founded(service.getByID(id));
    }

    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createDeliveryNote(@Argument InputDeliveryNote input) {
        service.create(input);
        return responses.created();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updateDeliveryNote(@Argument UUID id, @Argument InputDeliveryNote input) {
        service.update(id, input);
        return responses.updated();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deleteDeliveryNote(@Argument UUID id) {
        service.delete(id);
        return responses.deleted();
    }
}
