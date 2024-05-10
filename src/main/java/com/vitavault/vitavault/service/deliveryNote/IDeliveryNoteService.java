package com.vitavault.vitavault.service.deliveryNote;

import com.vitavault.vitavault.model.domain.DeliveryNote;
import com.vitavault.vitavault.model.input.InputDeliveryNote;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IDeliveryNoteService extends IBaseService<DeliveryNote>, ICreateUpdate<InputDeliveryNote> {
}
