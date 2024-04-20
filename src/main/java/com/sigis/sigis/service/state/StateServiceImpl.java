package com.sigis.sigis.service.state;

import com.sigis.sigis.domain.State;
import com.sigis.sigis.repository.StateRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class StateServiceImpl extends BaseServiceImpl<State, StateRepository> implements IStateService {
}
