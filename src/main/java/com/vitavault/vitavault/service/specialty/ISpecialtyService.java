package com.vitavault.vitavault.service.specialty;

import com.vitavault.vitavault.model.domain.Specialty;
import com.vitavault.vitavault.model.input.InputSpecialty;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface ISpecialtyService extends IBaseService<Specialty>, ICreateUpdate<InputSpecialty> {
}
