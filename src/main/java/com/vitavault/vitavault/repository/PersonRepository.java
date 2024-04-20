package com.vitavault.vitavault.repository;

import com.vitavault.vitavault.domain.Person;
import com.vitavault.vitavault.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseRepository<Person> {
}
