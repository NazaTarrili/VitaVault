package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.DeliveryNoteType;
import com.vitavault.vitavault.model.input.InputDeliveryNoteType;
import com.vitavault.vitavault.service.type.deliveryNote.IDeliveryNoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class DeliveryNoteTypeResource {
    @Autowired
    private IDeliveryNoteTypeService service;

    //Queries
    @QueryMapping
    public List<DeliveryNoteType> getAllDeliveryNoteType() {
        return service.getAll();
    }

    @QueryMapping
    public DeliveryNoteType getDeliveryNoteType(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createDeliveryNoteType(@Argument InputDeliveryNoteType input) {
        service.create(input);
    }

    @MutationMapping
    public void updateDeliveryNoteType(@Argument UUID id, @Argument InputDeliveryNoteType input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteDeliveryNoteType(@Argument UUID id) {
        service.delete(id);
    }
}
