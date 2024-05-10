package com.vitavault.vitavault.service.availability;

import com.vitavault.vitavault.model.domain.Availability;
import com.vitavault.vitavault.model.input.InputAvailability;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IAvailabilityService extends IBaseService<Availability>, ICreateUpdate<InputAvailability> {
}
