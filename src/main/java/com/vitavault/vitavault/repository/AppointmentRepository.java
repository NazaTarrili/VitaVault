package com.vitavault.vitavault.repository;

import com.vitavault.vitavault.domain.Appointment;
import com.vitavault.vitavault.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends BaseRepository<Appointment> {
}
