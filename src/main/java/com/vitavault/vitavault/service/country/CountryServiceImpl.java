package com.vitavault.vitavault.service.country;

import com.vitavault.vitavault.model.domain.Country;
import com.vitavault.vitavault.model.input.InputCountry;
import com.vitavault.vitavault.repository.CountryRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CountryServiceImpl extends BaseServiceImpl<Country, CountryRepository> implements ICountryService {
    @Override
    public void create(InputCountry input) {

    }

    @Override
    public void update(UUID id, InputCountry input) {

    }
}
