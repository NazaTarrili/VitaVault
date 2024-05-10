package com.vitavault.vitavault.service.treatment;

import com.vitavault.vitavault.model.domain.Treatment;
import com.vitavault.vitavault.model.input.InputTreatment;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface ITreatmentService extends IBaseService<Treatment>, ICreateUpdate<InputTreatment> {
}
