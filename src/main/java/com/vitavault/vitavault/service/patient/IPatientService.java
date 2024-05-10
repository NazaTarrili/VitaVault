package com.vitavault.vitavault.service.patient;

import com.vitavault.vitavault.model.domain.Patient;
import com.vitavault.vitavault.model.input.InputPatient;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IPatientService extends IBaseService<Patient>, ICreateUpdate<InputPatient> {
}
