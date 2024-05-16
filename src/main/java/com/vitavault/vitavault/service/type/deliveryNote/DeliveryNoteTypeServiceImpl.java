package com.vitavault.vitavault.service.type.deliveryNote;

import com.vitavault.vitavault.model.domain.DeliveryNoteType;
import com.vitavault.vitavault.model.input.InputDeliveryNoteType;
import com.vitavault.vitavault.repository.DeliveryNoteTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class DeliveryNoteTypeServiceImpl extends BaseServiceImpl<DeliveryNoteType, DeliveryNoteTypeRepository> implements IDeliveryNoteTypeService {
    private final String className = DeliveryNoteType.class.getName();

    @Override
    public void create(InputDeliveryNoteType input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new DeliveryNoteType(input.name()));
    }

    @Override
    public void update(UUID id, InputDeliveryNoteType input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        DeliveryNoteType deliveryNoteType = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            deliveryNoteType.setName(input.name());

        repository.save(deliveryNoteType);
    }
}
