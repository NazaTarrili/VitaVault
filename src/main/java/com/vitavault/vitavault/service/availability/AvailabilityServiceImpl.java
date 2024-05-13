package com.vitavault.vitavault.service.availability;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.Availability;
import com.vitavault.vitavault.model.input.InputAvailability;
import com.vitavault.vitavault.repository.AvailabilityRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.schedule.IScheduleService;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class AvailabilityServiceImpl extends BaseServiceImpl<Availability, AvailabilityRepository> implements IAvailabilityService {
    @Autowired
    private IValidateProperty validate;

    @Autowired
    private IScheduleService scheduleService;

    @Override
    public void create(InputAvailability input) {
        if (!validate.isLocalDate(input.day()))
            throw new InvalidRequestException("Availability: day is required.");

        if (!validate.isLocalTime(input.start()))
            throw new InvalidRequestException("Availability: start is required.");

        if (!validate.isLocalTime(input.end()))
            throw new InvalidRequestException("Availability: end is required.");

        if (!validate.isUUID(input.schedule()))
            throw new InvalidRequestException("Availability: schedule is required.");

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
        Availability availability = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Availability: not found ID."));

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
