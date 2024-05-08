package com.vitavault.vitavault.service.deliveryNote;

import com.vitavault.vitavault.model.domain.DeliveryNote;
import com.vitavault.vitavault.repository.DeliveryNoteRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class DeliveryNoteServiceImpl extends BaseServiceImpl<DeliveryNote, DeliveryNoteRepository> implements IDeliveryNoteService {
}
