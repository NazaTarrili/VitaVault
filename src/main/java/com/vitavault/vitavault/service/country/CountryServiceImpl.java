package com.vitavault.vitavault.service.country;

import com.vitavault.vitavault.model.domain.Country;
import com.vitavault.vitavault.repository.CountryRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class CountryServiceImpl extends BaseServiceImpl<Country, CountryRepository> implements ICountryService {
}
