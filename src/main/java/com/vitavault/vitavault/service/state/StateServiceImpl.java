package com.vitavault.vitavault.service.state;

import com.vitavault.vitavault.model.domain.State;
import com.vitavault.vitavault.model.input.InputState;
import com.vitavault.vitavault.repository.StateRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class StateServiceImpl extends BaseServiceImpl<State, StateRepository> implements IStateService {
    @Override
    public void create(InputState input) {

    }

    @Override
    public void update(UUID id, InputState input) {

    }
}
