package com.vitavault.vitavault.service.type.deliveryNote;

import com.vitavault.vitavault.model.domain.DeliveryNoteType;
import com.vitavault.vitavault.model.input.InputDeliveryNoteType;
import com.vitavault.vitavault.repository.DeliveryNoteTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class DeliveryNoteTypeServiceImpl extends BaseServiceImpl<DeliveryNoteType, DeliveryNoteTypeRepository> implements IDeliveryNoteTypeService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputDeliveryNoteType input) {

    }

    @Override
    public void update(UUID id, InputDeliveryNoteType input) {

    }
}
