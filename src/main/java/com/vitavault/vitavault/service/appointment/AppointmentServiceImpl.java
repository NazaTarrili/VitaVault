package com.vitavault.vitavault.service.appointment;

import com.vitavault.vitavault.model.domain.Appointment;
import com.vitavault.vitavault.model.input.InputAppointment;
import com.vitavault.vitavault.repository.AppointmentRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.patient.IPatientService;
import com.vitavault.vitavault.service.schedule.IScheduleService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class AppointmentServiceImpl extends BaseServiceImpl<Appointment, AppointmentRepository> implements IAppointmentService {
    private final String className = Appointment.class.getName();

    @Autowired
    private IScheduleService scheduleService;

    @Autowired
    private IPatientService patientService;

    @Override
    @Transactional
    public void create(InputAppointment input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("date", input.date()), className);
        requestValidator.invalidRequest(new Property("finished", input.finished()), className);
        requestValidator.invalidRequest(new Property("schedule", input.schedule()), className);
        requestValidator.invalidRequest(new Property("patient", input.patient()), className);

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
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Appointment appointment = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

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
