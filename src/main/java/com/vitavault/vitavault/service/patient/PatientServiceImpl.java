package com.vitavault.vitavault.service.patient;

import com.vitavault.vitavault.model.domain.Patient;
import com.vitavault.vitavault.repository.PatientRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class PatientServiceImpl extends BaseServiceImpl<Patient, PatientRepository> implements IPatientService {
}
