package com.vitavault.vitavault.service.specialty;

import com.vitavault.vitavault.model.domain.Specialty;
import com.vitavault.vitavault.repository.SpecialtyRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SpecialtyServiceImpl extends BaseServiceImpl<Specialty, SpecialtyRepository> implements ISpecialtyService {
}
