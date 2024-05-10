package com.vitavault.vitavault.service.city;

import com.vitavault.vitavault.model.domain.City;
import com.vitavault.vitavault.model.input.InputCity;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface ICityService extends IBaseService<City>, ICreateUpdate<InputCity> {
}
