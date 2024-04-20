package com.vitavault.vitavault.service.appointment;

import com.vitavault.vitavault.domain.Appointment;
import com.vitavault.vitavault.repository.AppointmentRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class AppointmentServiceImpl extends BaseServiceImpl<Appointment, AppointmentRepository> implements IAppointmentService {
}
