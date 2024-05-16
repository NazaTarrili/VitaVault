package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.EpisodeType;
import com.vitavault.vitavault.model.input.InputEpisodeType;
import com.vitavault.vitavault.service.type.episode.IEpisodeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class EpisodeTypeResource {
    @Autowired
    private IEpisodeTypeService service;
    
    //Queries
    @QueryMapping
    public List<EpisodeType> getAllEpisodeType() {
        return service.getAll();
    }

    @QueryMapping
    public EpisodeType getEpisodeType(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createEpisodeType(@Argument InputEpisodeType input) {
        service.create(input);
    }

    @MutationMapping
    public void updateEpisodeType(@Argument UUID id, @Argument InputEpisodeType input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteEpisodeType(@Argument UUID id) {
        service.delete(id);
    }
}
