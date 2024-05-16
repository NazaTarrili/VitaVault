package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Person;
import com.vitavault.vitavault.model.input.InputPerson;
import com.vitavault.vitavault.service.person.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class PersonResource {
    @Autowired
    private IPersonService service;
    
    //Queries
    @QueryMapping
    public List<Person> getAllPerson() {
        return service.getAll();
    }

    @QueryMapping
    public Person getPerson(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createPerson(@Argument InputPerson input) {
        service.create(input);
    }

    @MutationMapping
    public void updatePerson(@Argument UUID id, @Argument InputPerson input) {
        service.update(id, input);
    }

    @MutationMapping
    public void delete(@Argument UUID id) {
        service.delete(id);
    }
}
