package com.vitavault.vitavault.service.appointment;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.Appointment;
import com.vitavault.vitavault.model.input.InputAppointment;
import com.vitavault.vitavault.repository.AppointmentRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.patient.IPatientService;
import com.vitavault.vitavault.service.schedule.IScheduleService;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class AppointmentServiceImpl extends BaseServiceImpl<Appointment, AppointmentRepository> implements IAppointmentService {
    @Autowired
    private IValidateProperty validate;

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private IScheduleService scheduleService;

    @Autowired
    private IPatientService patientService;

    @Override
    @Transactional
    public void create(InputAppointment input) {
        if (!validate.isLocalDateTime(input.date()))
            throw new InvalidRequestException("Appointment: date is required.");

        if (!validate.isBoolean(input.finished()))
            throw new InvalidRequestException("Appointment: finished is required.");

        if (!validate.isUUID(input.schedule()))
            throw new InvalidRequestException("Appointment: schedule is required.");

        if (!validate.isUUID(input.patient()))
            throw new InvalidRequestException("Appointment: patient is required.");

        repository.save(
                Appointment.builder()
                        .date(input.date())
                        .finished(input.finished())
                        .schedule(scheduleService.getByID(input.schedule()))
                        .patient(patientService.getByID(input.patient()))
                        .build()
        );
    }

    @Override
    @Transactional
    public void update(UUID id, InputAppointment input) {
        Appointment appointment = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Appointment: not found ID."));

        if (validate.isLocalDateTime(input.date()))
            appointment.setDate(input.date());

        if (validate.isBoolean(input.finished()))
            appointment.setFinished(input.finished());

        if (validate.isUUID(input.schedule()))
            appointment.setSchedule(scheduleService.getByID(input.schedule()));

        if (validate.isUUID(input.patient()))
            appointment.setPatient(patientService.getByID(input.patient()));

        repository.save(appointment);
    }
}
