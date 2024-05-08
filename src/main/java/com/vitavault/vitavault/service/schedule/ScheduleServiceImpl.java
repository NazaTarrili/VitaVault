package com.vitavault.vitavault.service.schedule;

import com.vitavault.vitavault.model.domain.Schedule;
import com.vitavault.vitavault.repository.ScheduleRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class ScheduleServiceImpl extends BaseServiceImpl<Schedule, ScheduleRepository> implements IScheduleService {
}
