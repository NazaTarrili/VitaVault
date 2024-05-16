package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.State;
import com.vitavault.vitavault.model.input.InputState;
import com.vitavault.vitavault.service.state.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class StateResource {
    @Autowired
    private IStateService service;
    
    //Queries
    @QueryMapping
    public List<State> getAllState() {
        return service.getAll();
    }

    @QueryMapping
    public State getState(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createState(@Argument InputState input) {
        service.create(input);
    }

    @MutationMapping
    public void updateState(@Argument UUID id, @Argument InputState input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteState(@Argument UUID id) {
        service.delete(id);
    }
}
