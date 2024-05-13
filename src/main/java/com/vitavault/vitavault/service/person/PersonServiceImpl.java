package com.vitavault.vitavault.service.person;

import com.vitavault.vitavault.model.domain.Person;
import com.vitavault.vitavault.model.input.InputPerson;
import com.vitavault.vitavault.repository.PersonRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, PersonRepository> implements IPersonService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputPerson input) {

    }

    @Override
    public void update(UUID id, InputPerson input) {

    }
}
