package com.sigis.sigis.service.treatment;

import com.sigis.sigis.domain.Treatment;
import com.sigis.sigis.repository.TreatmentRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class TreatmentServiceImpl extends BaseServiceImpl<Treatment, TreatmentRepository> implements ITreatmentService {
}
