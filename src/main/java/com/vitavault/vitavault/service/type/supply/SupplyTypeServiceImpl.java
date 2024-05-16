package com.vitavault.vitavault.service.type.supply;

import com.vitavault.vitavault.model.domain.SupplyType;
import com.vitavault.vitavault.model.input.InputSupplyType;
import com.vitavault.vitavault.repository.SupplyTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SupplyTypeServiceImpl extends BaseServiceImpl<SupplyType, SupplyTypeRepository> implements ISupplyTypeService {
    private final String className = SupplyType.class.getName();

    @Override
    public void create(InputSupplyType input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new SupplyType(input.name()));
    }

    @Override
    public void update(UUID id, InputSupplyType input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        SupplyType supplyType = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            supplyType.setName(input.name());

        repository.save(supplyType);
    }
}
