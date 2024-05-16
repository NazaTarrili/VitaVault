package com.vitavault.vitavault.service.country;

import com.vitavault.vitavault.model.domain.Country;
import com.vitavault.vitavault.model.input.InputCountry;
import com.vitavault.vitavault.repository.CountryRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CountryServiceImpl extends BaseServiceImpl<Country, CountryRepository> implements ICountryService {
    private final String className = Country.class.getName();

    @Override
    public void create(InputCountry input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new Country(input.name()));
    }

    @Override
    public void update(UUID id, InputCountry input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Country country = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            country.setName(input.name());

        repository.save(country);
    }
}
