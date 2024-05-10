package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.input.InputPatient;
import com.vitavault.vitavault.service.patient.IPatientService;
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
public class PatientResource {
    @Autowired
    private IPatientService service;

    @Autowired
    private CustomResponses responses;
    
    //Queries
    @QueryMapping
    public ResponseEntity<ResponseFormatter> getAllPatient() {
        return responses.founded(service.getAll());
    }

    @QueryMapping
    public ResponseEntity<ResponseFormatter> getPatient(@Argument UUID id) {
        return responses.founded(service.getByID(id));
    }
    
    //Mutations
    @MutationMapping
    public ResponseEntity<ResponseFormatter> createPatient(@Argument InputPatient input) {
        service.create(input);
        return responses.created();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> updatePatient(@Argument UUID id, @Argument InputPatient input) {
        service.update(id, input);
        return responses.updated();
    }

    @MutationMapping
    public ResponseEntity<ResponseFormatter> deletePatient(@Argument UUID id) {
        service.delete(id);
        return responses.deleted();
    }
}
