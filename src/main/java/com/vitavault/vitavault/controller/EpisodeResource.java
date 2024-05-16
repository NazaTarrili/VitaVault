package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Episode;
import com.vitavault.vitavault.model.input.InputEpisode;
import com.vitavault.vitavault.service.episode.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class EpisodeResource {
    @Autowired
    private IEpisodeService service;
    
    //Queries
    @QueryMapping
    public List<Episode> getAllEpisode() {
        return service.getAll();
    }

    @QueryMapping
    public Episode getEpisode(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createEpisode(@Argument InputEpisode input) {
        service.create(input);
    }

    @MutationMapping
    public void updateEpisode(@Argument UUID id, @Argument InputEpisode input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteEpisode(@Argument UUID id) {
        service.delete(id);
    }
}
