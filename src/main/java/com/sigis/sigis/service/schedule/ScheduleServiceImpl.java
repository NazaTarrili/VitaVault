package com.sigis.sigis.service.schedule;

import com.sigis.sigis.domain.Schedule;
import com.sigis.sigis.repository.ScheduleRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class ScheduleServiceImpl extends BaseServiceImpl<Schedule, ScheduleRepository> implements IScheduleService {
}
