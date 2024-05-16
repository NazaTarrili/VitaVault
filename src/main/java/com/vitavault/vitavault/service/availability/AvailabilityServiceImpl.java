package com.vitavault.vitavault.service.availability;

import com.vitavault.vitavault.model.domain.Availability;
import com.vitavault.vitavault.model.input.InputAvailability;
import com.vitavault.vitavault.repository.AvailabilityRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.schedule.IScheduleService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class AvailabilityServiceImpl extends BaseServiceImpl<Availability, AvailabilityRepository> implements IAvailabilityService {
    private final String className = Availability.class.getName();

    @Autowired
    private IScheduleService scheduleService;

    @Override
    public void create(InputAvailability input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("day", input.day()), className);
        requestValidator.invalidRequest(new Property("start", input.start()), className);
        requestValidator.invalidRequest(new Property("end", input.end()), className);
        requestValidator.invalidRequest(new Property("schedule", input.schedule()), className);

        repository.save(
                Availability.builder()
                        .day(input.day())
                        .start(input.start())
                        .end(input.end())
                        .schedule(scheduleService.getByID(input.schedule()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputAvailability input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Availability availability = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isLocalDate(input.day()))
            availability.setDay(input.day());

        if (validate.isLocalTime(input.start()))
            availability.setStart(input.start());

        if (validate.isLocalTime(input.end()))
            availability.setEnd(input.end());

        if (validate.isUUID(input.schedule()))
            availability.setSchedule(scheduleService.getByID(input.schedule()));

        repository.save(availability);
    }
}
