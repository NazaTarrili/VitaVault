package com.vitavault.vitavault.service.schedule;

import com.vitavault.vitavault.model.domain.Schedule;
import com.vitavault.vitavault.model.input.InputSchedule;
import com.vitavault.vitavault.repository.ScheduleRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ScheduleServiceImpl extends BaseServiceImpl<Schedule, ScheduleRepository> implements IScheduleService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputSchedule input) {

    }

    @Override
    public void update(UUID id, InputSchedule input) {

    }
}
