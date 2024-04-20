package com.sigis.sigis.service.specialty;

import com.sigis.sigis.domain.Specialty;
import com.sigis.sigis.repository.SpecialtyRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SpecialtyServiceImpl extends BaseServiceImpl<Specialty, SpecialtyRepository> implements ISpecialtyService {
}
