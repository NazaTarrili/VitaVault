package com.vitavault.vitavault.service.city;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.City;
import com.vitavault.vitavault.model.input.InputCity;
import com.vitavault.vitavault.repository.CityRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.state.IStateService;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CityServiceImpl extends BaseServiceImpl<City, CityRepository> implements ICityService {
    @Autowired
    private IValidateProperty validate;

    @Autowired
    private CityRepository repository;

    @Autowired
    private IStateService stateService;

    @Override
    public void create(InputCity input) {
        if (!validate.isNonEmptyString(input.name()))
            throw new InvalidRequestException("City: name is required.");

        if (!validate.isUUID(input.state()))
            throw new InvalidRequestException("City: state is required.");

        repository.save(
                City.builder()
                        .name(input.name())
                        .state(stateService.getByID(input.state()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputCity input) {
        City city = repository.findById(id).orElseThrow(() ->
                new NotFoundException("City: not found ID."));

        if (validate.isNonEmptyString(input.name()))
            city.setName(input.name());

        if (validate.isUUID(input.state()))
            city.setState(stateService.getByID(input.state()));

        repository.save(city);
    }
}
