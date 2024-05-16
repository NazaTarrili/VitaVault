package com.vitavault.vitavault.service.city;

import com.vitavault.vitavault.model.domain.City;
import com.vitavault.vitavault.model.input.InputCity;
import com.vitavault.vitavault.repository.CityRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.state.IStateService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CityServiceImpl extends BaseServiceImpl<City, CityRepository> implements ICityService {
    private final String className = City.class.getName();

    @Autowired
    private IStateService stateService;

    @Override
    public void create(InputCity input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("state", input.state()), className);

        repository.save(
                City.builder()
                        .name(input.name())
                        .state(stateService.getByID(input.state()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputCity input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        City city = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            city.setName(input.name());

        if (validate.isUUID(input.state()))
            city.setState(stateService.getByID(input.state()));

        repository.save(city);
    }
}
