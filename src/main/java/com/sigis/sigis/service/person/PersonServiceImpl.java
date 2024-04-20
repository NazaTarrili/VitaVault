package com.sigis.sigis.service.person;

import com.sigis.sigis.domain.Person;
import com.sigis.sigis.repository.PersonRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, PersonRepository> implements IPersonService {
}
