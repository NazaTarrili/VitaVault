package com.vitavault.vitavault.service.user;

import com.vitavault.vitavault.model.domain.User;
import com.vitavault.vitavault.model.input.InputUser;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IUserService extends IBaseService<User>, ICreateUpdate<InputUser> {
}
