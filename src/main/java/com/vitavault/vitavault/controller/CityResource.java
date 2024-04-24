package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.City;
import com.vitavault.vitavault.service.city.CityServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/city")
@CrossOrigin(origins = "*")
public class CityResource extends BaseControllerImpl<City, CityServiceImpl> {
}
