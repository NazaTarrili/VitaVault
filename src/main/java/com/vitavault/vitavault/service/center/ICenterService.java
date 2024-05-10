package com.vitavault.vitavault.service.center;

import com.vitavault.vitavault.model.domain.Center;
import com.vitavault.vitavault.model.input.InputCenter;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface ICenterService extends IBaseService<Center>, ICreateUpdate<InputCenter> {
}
