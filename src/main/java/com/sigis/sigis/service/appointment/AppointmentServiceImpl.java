package com.sigis.sigis.service.appointment;

import com.sigis.sigis.domain.Appointment;
import com.sigis.sigis.repository.AppointmentRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class AppointmentServiceImpl extends BaseServiceImpl<Appointment, AppointmentRepository> implements IAppointmentService {
}
