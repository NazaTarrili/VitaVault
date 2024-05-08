package com.vitavault.vitavault.service.person;

import com.vitavault.vitavault.model.domain.Person;
import com.vitavault.vitavault.repository.PersonRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, PersonRepository> implements IPersonService {
}
