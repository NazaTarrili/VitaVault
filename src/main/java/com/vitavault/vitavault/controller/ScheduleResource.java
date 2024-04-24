package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Schedule;
import com.vitavault.vitavault.service.schedule.ScheduleServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/schedule")
@CrossOrigin(origins = "*")
public class ScheduleResource extends BaseControllerImpl<Schedule, ScheduleServiceImpl> {
}
