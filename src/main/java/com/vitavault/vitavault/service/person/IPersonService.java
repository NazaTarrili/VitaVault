package com.vitavault.vitavault.service.person;

import com.vitavault.vitavault.model.domain.Person;
import com.vitavault.vitavault.model.input.InputPerson;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IPersonService extends IBaseService<Person>, ICreateUpdate<InputPerson> {
}
