package com.vitavault.vitavault.service.street;

import com.vitavault.vitavault.model.domain.Street;
import com.vitavault.vitavault.model.input.InputStreet;
import com.vitavault.vitavault.repository.StreetRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class StreetServiceImpl extends BaseServiceImpl<Street, StreetRepository> implements IStreetService {
    private final String className = Street.class.getName();

    @Override
    public void create(InputStreet input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new Street(input.name()));
    }

    @Override
    public void update(UUID id, InputStreet input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Street street = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            street.setName(input.name());

        repository.save(street);
    }
}
