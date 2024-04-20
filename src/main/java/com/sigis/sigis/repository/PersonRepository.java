package com.sigis.sigis.repository;

import com.sigis.sigis.domain.Person;
import com.sigis.sigis.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseRepository<Person> {
}
