package com.sigis.sigis.controller;

import com.sigis.sigis.controller.base.BaseControllerImpl;
import com.sigis.sigis.domain.Treatment;
import com.sigis.sigis.service.treatment.TreatmentServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/treatment", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class TreatmentResource extends BaseControllerImpl<Treatment, TreatmentServiceImpl> {
}
