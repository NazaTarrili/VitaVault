package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Patient;
import com.vitavault.vitavault.service.patient.PatientServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/patient")
@CrossOrigin(origins = "*")
public class PatientResource extends BaseControllerImpl<Patient, PatientServiceImpl> {
}
