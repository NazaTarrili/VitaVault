package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.City;
import com.vitavault.vitavault.model.input.InputCity;
import com.vitavault.vitavault.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class CityResource {
    @Autowired
    private ICityService service;

    //Queries
    @QueryMapping
    public List<City> getAllCity() {
        return service.getAll();
    }

    @QueryMapping
    public City getCity(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createCity(@Argument InputCity input) {
        service.create(input);
    }

    @MutationMapping
    public void updateCity(@Argument UUID id, @Argument InputCity input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteCity(@Argument UUID id) {
        service.delete(id);
    }
}
