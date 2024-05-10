package com.vitavault.vitavault.service.country;

import com.vitavault.vitavault.model.domain.Country;
import com.vitavault.vitavault.model.input.InputCountry;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface ICountryService extends IBaseService<Country>, ICreateUpdate<InputCountry> {
}
