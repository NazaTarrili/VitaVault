package com.vitavault.vitavault.service.deliveryNote;

import com.vitavault.vitavault.model.domain.DeliveryNote;
import com.vitavault.vitavault.model.input.InputDeliveryNote;
import com.vitavault.vitavault.repository.DeliveryNoteRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.supply.ISupplyService;
import com.vitavault.vitavault.service.type.deliveryNote.IDeliveryNoteTypeService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class DeliveryNoteServiceImpl extends BaseServiceImpl<DeliveryNote, DeliveryNoteRepository> implements IDeliveryNoteService {
    private final String className = DeliveryNote.class.getName();

    @Autowired
    private IDeliveryNoteTypeService deliveryNoteTypeService;

    @Autowired
    private ISupplyService supplyService;

    @Override
    public void create(InputDeliveryNote input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("date", input.date()), className);
        requestValidator.invalidRequest(new Property("quantity", input.quantity()), className);
        requestValidator.invalidRequest(new Property("delivery note type", input.deliveryNoteType()), className);
        requestValidator.invalidRequest(new Property("supply", input.supply()), className);

        repository.save(
                DeliveryNote.builder()
                        .date(input.date())
                        .quantity(input.quantity())
                        .deliveryNoteType(deliveryNoteTypeService.getByID(input.deliveryNoteType()))
                        .supply(supplyService.getByID(input.supply()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputDeliveryNote input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        DeliveryNote deliveryNote = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isLocalDateTime(input.date()))
            deliveryNote.setDate(input.date());

        if (validate.isInteger(input.quantity()))
            deliveryNote.setQuantity(input.quantity());

        if (validate.isUUID(input.deliveryNoteType()))
            deliveryNote.setDeliveryNoteType(deliveryNoteTypeService.getByID(input.deliveryNoteType()));

        if (validate.isUUID(input.supply()))
            deliveryNote.setSupply(supplyService.getByID(input.supply()));

        repository.save(deliveryNote);
    }
}
