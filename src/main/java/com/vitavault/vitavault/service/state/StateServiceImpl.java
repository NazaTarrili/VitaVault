package com.vitavault.vitavault.service.state;

import com.vitavault.vitavault.domain.State;
import com.vitavault.vitavault.repository.StateRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class StateServiceImpl extends BaseServiceImpl<State, StateRepository> implements IStateService {
}
