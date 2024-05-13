package com.vitavault.vitavault.service.state;

import com.vitavault.vitavault.model.domain.State;
import com.vitavault.vitavault.model.input.InputState;
import com.vitavault.vitavault.repository.StateRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class StateServiceImpl extends BaseServiceImpl<State, StateRepository> implements IStateService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputState input) {

    }

    @Override
    public void update(UUID id, InputState input) {

    }
}
