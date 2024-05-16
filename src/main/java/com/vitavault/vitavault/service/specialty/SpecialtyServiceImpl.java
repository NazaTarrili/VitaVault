package com.vitavault.vitavault.service.specialty;

import com.vitavault.vitavault.model.domain.Specialty;
import com.vitavault.vitavault.model.input.InputSpecialty;
import com.vitavault.vitavault.repository.SpecialtyRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SpecialtyServiceImpl extends BaseServiceImpl<Specialty, SpecialtyRepository> implements ISpecialtyService {
    private final String className = Specialty.class.getName();

    @Override
    public void create(InputSpecialty input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new Specialty(input.name()));
    }

    @Override
    public void update(UUID id, InputSpecialty input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Specialty specialty = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            specialty.setName(input.name());

        repository.save(specialty);
    }
}
