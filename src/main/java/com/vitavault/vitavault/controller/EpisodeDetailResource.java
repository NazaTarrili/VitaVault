package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.EpisodeDetail;
import com.vitavault.vitavault.model.input.InputEpisodeDetail;
import com.vitavault.vitavault.service.episodeDetail.IEpisodeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class EpisodeDetailResource {
    @Autowired
    private IEpisodeDetailService service;
    
    //Queries
    @QueryMapping
    public List<EpisodeDetail> getAllEpisodeDetail() {
        return service.getAll();
    }

    @QueryMapping
    public EpisodeDetail getEpisodeDetail(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createEpisodeDetail(@Argument InputEpisodeDetail input) {
        service.create(input);
    }

    @MutationMapping
    public void updateEpisodeDetail(@Argument UUID id, @Argument InputEpisodeDetail input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteEpisodeDetail(@Argument UUID id) {
        service.delete(id);
    }
}
