package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.DeliveryNote;
import com.vitavault.vitavault.model.input.InputDeliveryNote;
import com.vitavault.vitavault.service.deliveryNote.IDeliveryNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class DeliveryNoteResource {
    @Autowired
    private IDeliveryNoteService service;

    //Queries
    @QueryMapping
    public List<DeliveryNote> getAllDeliveryNote() {
        return service.getAll();
    }

    @QueryMapping
    public DeliveryNote getDeliveryNote(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createDeliveryNote(@Argument InputDeliveryNote input) {
        service.create(input);
    }

    @MutationMapping
    public void updateDeliveryNote(@Argument UUID id, @Argument InputDeliveryNote input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteDeliveryNote(@Argument UUID id) {
        service.delete(id);
    }
}
