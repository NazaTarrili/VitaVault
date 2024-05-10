package com.vitavault.vitavault.service.specialty;

import com.vitavault.vitavault.model.domain.Specialty;
import com.vitavault.vitavault.model.input.InputSpecialty;
import com.vitavault.vitavault.repository.SpecialtyRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SpecialtyServiceImpl extends BaseServiceImpl<Specialty, SpecialtyRepository> implements ISpecialtyService {
    @Override
    public void create(InputSpecialty input) {

    }

    @Override
    public void update(UUID id, InputSpecialty input) {

    }
}
