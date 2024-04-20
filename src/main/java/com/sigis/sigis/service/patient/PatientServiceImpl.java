package com.sigis.sigis.service.patient;

import com.sigis.sigis.domain.Patient;
import com.sigis.sigis.repository.PatientRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class PatientServiceImpl extends BaseServiceImpl<Patient, PatientRepository> implements IPatientService {
}
