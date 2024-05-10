package com.vitavault.vitavault.service.street;

import com.vitavault.vitavault.model.domain.Street;
import com.vitavault.vitavault.model.input.InputStreet;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IStreetService extends IBaseService<Street>, ICreateUpdate<InputStreet> {
}
