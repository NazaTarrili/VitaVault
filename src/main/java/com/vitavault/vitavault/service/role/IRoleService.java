package com.vitavault.vitavault.service.role;

import com.vitavault.vitavault.model.domain.Role;
import com.vitavault.vitavault.model.input.InputRole;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IRoleService extends IBaseService<Role>, ICreateUpdate<InputRole> {
}
