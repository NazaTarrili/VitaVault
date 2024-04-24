package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Treatment;
import com.vitavault.vitavault.service.treatment.TreatmentServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/treatment")
@CrossOrigin(origins = "*")
public class TreatmentResource extends BaseControllerImpl<Treatment, TreatmentServiceImpl> {
}
