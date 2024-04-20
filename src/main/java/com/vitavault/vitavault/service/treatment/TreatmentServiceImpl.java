package com.vitavault.vitavault.service.treatment;

import com.vitavault.vitavault.domain.Treatment;
import com.vitavault.vitavault.repository.TreatmentRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class TreatmentServiceImpl extends BaseServiceImpl<Treatment, TreatmentRepository> implements ITreatmentService {
}
