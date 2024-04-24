package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Specialty;
import com.vitavault.vitavault.service.specialty.SpecialtyServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/specialty")
@CrossOrigin(origins = "*")
public class SpecialtyResource extends BaseControllerImpl<Specialty, SpecialtyServiceImpl> {
}
