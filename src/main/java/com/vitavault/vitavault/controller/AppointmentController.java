package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Appointment;
import com.vitavault.vitavault.model.input.InputAppointment;
import com.vitavault.vitavault.service.appointment.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class AppointmentController {
    @Autowired
    private IAppointmentService service;

    //Queries
    @QueryMapping
    public List<Appointment> getAllAppointment() {
        return service.getAll();
    }

    @QueryMapping
    public Appointment getAppointment(@Argument UUID id) {
        return service.getByID(id);
    }

    //Mutations
    @MutationMapping
    public void createAppointment(@Argument InputAppointment input) {
        service.create(input);
    }

    @MutationMapping
    public void updateAppointment(@Argument UUID id, @Argument InputAppointment input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteAppointment(@Argument UUID id) {
        service.delete(id);
    }
}
