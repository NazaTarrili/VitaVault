package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Treatment;
import com.vitavault.vitavault.model.input.InputTreatment;
import com.vitavault.vitavault.service.treatment.ITreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class TreatmentResource {
    @Autowired
    private ITreatmentService service;
    
    //Queries
    @QueryMapping
    public List<Treatment> getAllTreatment() {
        return service.getAll();
    }

    @QueryMapping
    public Treatment getTreatment(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createTreatment(@Argument InputTreatment input) {
        service.create(input);
    }

    @MutationMapping
    public void updateTreatment(@Argument UUID id, @Argument InputTreatment input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteTreatment(@Argument UUID id) {
        service.delete(id);
    }
}
