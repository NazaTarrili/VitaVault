package com.vitavault.vitavault.service.state;

import com.vitavault.vitavault.model.domain.State;
import com.vitavault.vitavault.model.input.InputState;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IStateService extends IBaseService<State>, ICreateUpdate<InputState> {
}
