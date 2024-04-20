package com.sigis.sigis.repository;

import com.sigis.sigis.domain.Patient;
import com.sigis.sigis.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends BaseRepository<Patient> {
}
