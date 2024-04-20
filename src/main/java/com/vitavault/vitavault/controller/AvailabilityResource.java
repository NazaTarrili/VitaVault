package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.controller.base.BaseControllerImpl;
import com.vitavault.vitavault.domain.Availability;
import com.vitavault.vitavault.service.availability.AvailabilityServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/availability", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class AvailabilityResource extends BaseControllerImpl<Availability, AvailabilityServiceImpl> {
}
