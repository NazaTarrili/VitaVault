package com.sigis.sigis.repository;

import com.sigis.sigis.domain.Appointment;
import com.sigis.sigis.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends BaseRepository<Appointment> {
}