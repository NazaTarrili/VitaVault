package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Country;
import com.vitavault.vitavault.service.country.CountryServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/country")
@CrossOrigin(origins = "*")
public class CountryResource extends BaseControllerImpl<Country, CountryServiceImpl> {
}
