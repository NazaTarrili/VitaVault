package com.vitavault.vitavault.service.patient;

import com.vitavault.vitavault.model.domain.Patient;
import com.vitavault.vitavault.model.input.InputPatient;
import com.vitavault.vitavault.repository.PatientRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.person.IPersonService;
import com.vitavault.vitavault.service.plan.IPlanService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PatientServiceImpl extends BaseServiceImpl<Patient, PatientRepository> implements IPatientService {
    private final String className = Patient.class.getName();

    @Autowired
    private IPersonService personService;

    @Autowired
    private IPlanService planService;

    @Override
    public void create(InputPatient input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("person", input.person()), className);
        requestValidator.invalidRequest(new Property("plan", input.plan()), className);

        repository.save(
                Patient.builder()
                        .person(personService.getByID(input.person()))
                        .plan(planService.getByID(input.plan()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputPatient input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Patient patient = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isUUID(input.person()))
            patient.setPerson(personService.getByID(input.person()));

        if (validate.isUUID(input.plan()))
            patient.setPlan(planService.getByID(input.plan()));

        repository.save(patient);
    }
}
