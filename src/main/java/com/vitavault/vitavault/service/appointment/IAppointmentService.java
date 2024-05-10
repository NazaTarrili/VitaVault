package com.vitavault.vitavault.service.appointment;

import com.vitavault.vitavault.model.domain.Appointment;
import com.vitavault.vitavault.model.input.InputAppointment;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IAppointmentService extends IBaseService<Appointment>, ICreateUpdate<InputAppointment> {
}
