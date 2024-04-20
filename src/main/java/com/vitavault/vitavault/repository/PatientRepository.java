package com.vitavault.vitavault.repository;

import com.vitavault.vitavault.domain.Patient;
import com.vitavault.vitavault.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends BaseRepository<Patient> {
}
