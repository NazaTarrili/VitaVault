package com.sigis.sigis.service.deliveryNote;

import com.sigis.sigis.domain.DeliveryNote;
import com.sigis.sigis.repository.DeliveryNoteRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class DeliveryNoteServiceImpl extends BaseServiceImpl<DeliveryNote, DeliveryNoteRepository> implements IDeliveryNoteService {
}
