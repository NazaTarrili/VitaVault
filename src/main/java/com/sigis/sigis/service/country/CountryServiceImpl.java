package com.sigis.sigis.service.country;

import com.sigis.sigis.domain.Country;
import com.sigis.sigis.repository.CountryRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class CountryServiceImpl extends BaseServiceImpl<Country, CountryRepository> implements ICountryService {
}
