package com.vitavault.vitavault.service.periodicity;

import com.vitavault.vitavault.model.domain.Periodicity;
import com.vitavault.vitavault.model.input.InputPeriodicity;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IPeriodicityService extends IBaseService<Periodicity>, ICreateUpdate<InputPeriodicity> {
}
