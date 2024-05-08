package com.vitavault.vitavault.service.type.deliveryNote;

import com.vitavault.vitavault.model.domain.DeliveryNoteType;
import com.vitavault.vitavault.repository.DeliveryNoteTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class DeliveryNoteTypeServiceImpl extends BaseServiceImpl<DeliveryNoteType, DeliveryNoteTypeRepository> implements IDeliveryNoteTypeService {
}
