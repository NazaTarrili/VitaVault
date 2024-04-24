package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Street;
import com.vitavault.vitavault.service.street.StreetServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/street")
@CrossOrigin(origins = "*")
public class StreetResource extends BaseControllerImpl<Street, StreetServiceImpl> {
}
