package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Person;
import com.vitavault.vitavault.service.person.PersonServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/person")
@CrossOrigin(origins = "*")
public class PersonResource extends BaseControllerImpl<Person, PersonServiceImpl> {
}
