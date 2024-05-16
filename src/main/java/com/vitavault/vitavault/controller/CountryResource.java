package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Country;
import com.vitavault.vitavault.model.input.InputCountry;
import com.vitavault.vitavault.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class CountryResource {
    @Autowired
    private ICountryService service;

    //Queries
    @QueryMapping
    public List<Country> getAllCountry() {
        return service.getAll();
    }

    @QueryMapping
    public Country getCountry(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createCountry(@Argument InputCountry input) {
        service.create(input);
    }

    @MutationMapping
    public void updateCountry(@Argument UUID id, @Argument InputCountry input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteCountry(@Argument UUID id) {
        service.delete(id);
    }
}
