package com.vitavault.vitavault.service.country;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.Country;
import com.vitavault.vitavault.model.input.InputCountry;
import com.vitavault.vitavault.repository.CountryRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CountryServiceImpl extends BaseServiceImpl<Country, CountryRepository> implements ICountryService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputCountry input) {
        if (!validate.isNonEmptyString(input.name()))
            throw new InvalidRequestException("Country: name is required.");

        repository.save(new Country(input.name()));
    }

    @Override
    public void update(UUID id, InputCountry input) {
        Country country = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Country: not found ID."));

        if (validate.isNonEmptyString(input.name()))
            country.setName(input.name());

        repository.save(country);
    }
}
