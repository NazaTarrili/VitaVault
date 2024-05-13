package com.vitavault.vitavault.service.patient;

import com.vitavault.vitavault.model.domain.Patient;
import com.vitavault.vitavault.model.input.InputPatient;
import com.vitavault.vitavault.repository.PatientRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PatientServiceImpl extends BaseServiceImpl<Patient, PatientRepository> implements IPatientService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputPatient input) {

    }

    @Override
    public void update(UUID id, InputPatient input) {

    }
}
