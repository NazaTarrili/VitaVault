package com.vitavault.vitavault.service.person;

import com.vitavault.vitavault.model.domain.Person;
import com.vitavault.vitavault.model.input.InputPerson;
import com.vitavault.vitavault.repository.PersonRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, PersonRepository> implements IPersonService {
    @Override
    public void create(InputPerson input) {

    }

    @Override
    public void update(UUID id, InputPerson input) {

    }
}
