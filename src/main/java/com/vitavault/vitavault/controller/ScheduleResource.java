package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Schedule;
import com.vitavault.vitavault.model.input.InputSchedule;
import com.vitavault.vitavault.service.schedule.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class ScheduleResource {
    @Autowired
    private IScheduleService service;
    
    //Queries
    @QueryMapping
    public List<Schedule> getAllSchedule() {
        return service.getAll();
    }

    @QueryMapping
    public Schedule getSchedule(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createSchedule(@Argument InputSchedule input) {
        service.create(input);
    }

    @MutationMapping
    public void updateSchedule(@Argument UUID id, @Argument InputSchedule input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteSchedule(@Argument UUID id) {
        service.delete(id);
    }
}
