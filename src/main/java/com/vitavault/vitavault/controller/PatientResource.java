package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Patient;
import com.vitavault.vitavault.model.input.InputPatient;
import com.vitavault.vitavault.service.patient.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class PatientResource {
    @Autowired
    private IPatientService service;
    
    //Queries
    @QueryMapping
    public List<Patient> getAllPatient() {
        return service.getAll();
    }

    @QueryMapping
    public Patient getPatient(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createPatient(@Argument InputPatient input) {
        service.create(input);
    }

    @MutationMapping
    public void updatePatient(@Argument UUID id, @Argument InputPatient input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deletePatient(@Argument UUID id) {
        service.delete(id);
    }
}
