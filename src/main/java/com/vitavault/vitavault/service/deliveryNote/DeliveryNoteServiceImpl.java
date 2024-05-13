package com.vitavault.vitavault.service.deliveryNote;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.DeliveryNote;
import com.vitavault.vitavault.model.input.InputDeliveryNote;
import com.vitavault.vitavault.repository.DeliveryNoteRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.supply.ISupplyService;
import com.vitavault.vitavault.service.type.deliveryNote.IDeliveryNoteTypeService;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class DeliveryNoteServiceImpl extends BaseServiceImpl<DeliveryNote, DeliveryNoteRepository> implements IDeliveryNoteService {
    @Autowired
    private IValidateProperty validate;

    @Autowired
    private IDeliveryNoteTypeService deliveryNoteTypeService;

    @Autowired
    private ISupplyService supplyService;

    @Override
    public void create(InputDeliveryNote input) {
        if (!validate.isLocalDateTime(input.date()))
            throw new InvalidRequestException("Delivery note: date is required.");

        if (!validate.isInteger(input.quantity()))
            throw new InvalidRequestException("Delivery note: quantity is required.");

        if (!validate.isUUID(input.deliveryNoteType()))
            throw new InvalidRequestException("Delivery note: delivery note type is required.");

        if (!validate.isUUID(input.supply()))
            throw new InvalidRequestException("Delivery note: supply is required.");

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
        DeliveryNote deliveryNote = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Delivery note: not found ID."));

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
