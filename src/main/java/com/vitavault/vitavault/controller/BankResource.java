package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Bank;
import com.vitavault.vitavault.model.input.InputBank;
import com.vitavault.vitavault.service.bank.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class BankResource {
    @Autowired
    private IBankService service;

    //Queries
    @QueryMapping
    public List<Bank> getAllBank() {
        return service.getAll();
    }

    @QueryMapping
    public Bank getBank(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createBank(@Argument InputBank input) {
        service.create(input);
    }

    @MutationMapping
    public void updateBank(@Argument UUID id, @Argument InputBank input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteBank(@Argument UUID id) {
        service.delete(id);
    }
}
