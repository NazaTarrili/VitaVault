package com.vitavault.vitavault.service.schedule;

import com.vitavault.vitavault.model.domain.Schedule;
import com.vitavault.vitavault.model.input.InputSchedule;
import com.vitavault.vitavault.repository.ScheduleRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.specialty.ISpecialtyService;
import com.vitavault.vitavault.service.user.IUserService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ScheduleServiceImpl extends BaseServiceImpl<Schedule, ScheduleRepository> implements IScheduleService {
    private final String className = Schedule.class.getName();

    @Autowired
    private IUserService userService;

    @Autowired
    private ISpecialtyService specialtyService;

    @Override
    public void create(InputSchedule input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("user", input.user()), className);
        requestValidator.invalidRequest(new Property("specialty", input.specialty()), className);

        repository.save(
                Schedule.builder()
                        .user(userService.getByID(input.user()))
                        .speciality(specialtyService.getByID(input.specialty()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputSchedule input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Schedule schedule = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isUUID(input.user()))
            schedule.setUser(userService.getByID(input.user()));

        if (validate.isUUID(input.specialty()))
            schedule.setSpeciality(specialtyService.getByID(input.specialty()));

        repository.save(schedule);
    }
}
