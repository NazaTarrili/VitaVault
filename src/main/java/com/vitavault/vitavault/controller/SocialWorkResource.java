package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.SocialWork;
import com.vitavault.vitavault.model.input.InputSocialWork;
import com.vitavault.vitavault.service.socialWork.ISocialWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class SocialWorkResource {
    @Autowired
    private ISocialWorkService service;
    
    //Queries
    @QueryMapping
    public List<SocialWork> getAllSocialWork() {
        return service.getAll();
    }

    @QueryMapping
    public SocialWork getSocialWork(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createSocialWork(@Argument InputSocialWork input) {
        service.create(input);
    }

    @MutationMapping
    public void updateSocialWork(@Argument UUID id, @Argument InputSocialWork input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteSocialWork(@Argument UUID id) {
        service.delete(id);
    }
}
