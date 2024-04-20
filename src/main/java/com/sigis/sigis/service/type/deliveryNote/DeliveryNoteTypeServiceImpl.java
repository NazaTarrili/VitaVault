package com.sigis.sigis.service.type.deliveryNote;

import com.sigis.sigis.domain.DeliveryNoteType;
import com.sigis.sigis.repository.DeliveryNoteTypeRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class DeliveryNoteTypeServiceImpl extends BaseServiceImpl<DeliveryNoteType, DeliveryNoteTypeRepository> implements IDeliveryNoteTypeService {
}
