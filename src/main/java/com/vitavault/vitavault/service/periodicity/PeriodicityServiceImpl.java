package com.vitavault.vitavault.service.periodicity;

import com.vitavault.vitavault.model.domain.Periodicity;
import com.vitavault.vitavault.model.input.InputPeriodicity;
import com.vitavault.vitavault.repository.PeriodicityRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PeriodicityServiceImpl extends BaseServiceImpl<Periodicity, PeriodicityRepository> implements IPeriodicityService {
    private final String className = Periodicity.class.getName();

    @Override
    public void create(InputPeriodicity input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("day", input.day()), className);
        requestValidator.invalidRequest(new Property("start time", input.start()), className);
        requestValidator.invalidRequest(new Property("end time", input.end()), className);

        repository.save(
                Periodicity.builder()
                        .day(input.day())
                        .start(input.start())
                        .end(input.end())
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputPeriodicity input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Periodicity periodicity = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (!validate.isDayOfWeek(input.day()))
            periodicity.setDay(input.day());

        if (!validate.isLocalTime(input.start()))
            periodicity.setStart(input.start());

        if (!validate.isLocalTime(input.end()))
            periodicity.setEnd(input.end());

        repository.save(periodicity);
    }
}
