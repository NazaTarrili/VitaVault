package com.vitavault.vitavault.service.type.deliveryNote;

import com.vitavault.vitavault.model.domain.DeliveryNoteType;
import com.vitavault.vitavault.model.input.InputDeliveryNoteType;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IDeliveryNoteTypeService extends IBaseService<DeliveryNoteType>, ICreateUpdate<InputDeliveryNoteType> {
}
