package com.vitavault.vitavault.service.bed;

import com.vitavault.vitavault.model.domain.Bed;
import com.vitavault.vitavault.model.input.InputBed;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IBedService extends IBaseService<Bed>, ICreateUpdate<InputBed> {
}
