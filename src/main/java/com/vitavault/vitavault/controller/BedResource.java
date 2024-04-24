package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Bed;
import com.vitavault.vitavault.service.bed.BedServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/bed")
@CrossOrigin(origins = "*")
public class BedResource extends BaseControllerImpl<Bed, BedServiceImpl> {
}
