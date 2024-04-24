package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Periodicity;
import com.vitavault.vitavault.service.periodicity.PeriodicityServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/periodicity")
@CrossOrigin(origins = "*")
public class PeriodicityResource extends BaseControllerImpl<Periodicity, PeriodicityServiceImpl> {
}
