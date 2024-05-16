package com.vitavault.vitavault.service.treatment;

import com.vitavault.vitavault.model.domain.Treatment;
import com.vitavault.vitavault.model.input.InputTreatment;
import com.vitavault.vitavault.repository.TreatmentRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class TreatmentServiceImpl extends BaseServiceImpl<Treatment, TreatmentRepository> implements ITreatmentService {
    private final String className = Treatment.class.getName();

    @Override
    public void create(InputTreatment input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new Treatment(input.name()));
    }

    @Override
    public void update(UUID id, InputTreatment input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Treatment treatment = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            treatment.setName(input.name());

        repository.save(treatment);
    }
}
