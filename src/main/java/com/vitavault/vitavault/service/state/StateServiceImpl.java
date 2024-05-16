package com.vitavault.vitavault.service.state;

import com.vitavault.vitavault.model.domain.State;
import com.vitavault.vitavault.model.input.InputState;
import com.vitavault.vitavault.repository.StateRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.country.ICountryService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class StateServiceImpl extends BaseServiceImpl<State, StateRepository> implements IStateService {
    private final String className = State.class.getName();

    @Autowired
    private ICountryService countryService;

    @Override
    public void create(InputState input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("country", input.country()), className);

        repository.save(
                State.builder()
                        .name(input.name())
                        .country(countryService.getByID(input.country()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputState input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        State state = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            state.setName(input.name());

        if (validate.isUUID(input.country()))
            state.setCountry(countryService.getByID(input.country()));

        repository.save(state);
    }
}
