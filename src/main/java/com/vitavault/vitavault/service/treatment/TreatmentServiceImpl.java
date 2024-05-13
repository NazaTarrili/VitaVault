package com.vitavault.vitavault.service.treatment;

import com.vitavault.vitavault.model.domain.Treatment;
import com.vitavault.vitavault.model.input.InputTreatment;
import com.vitavault.vitavault.repository.TreatmentRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class TreatmentServiceImpl extends BaseServiceImpl<Treatment, TreatmentRepository> implements ITreatmentService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputTreatment input) {

    }

    @Override
    public void update(UUID id, InputTreatment input) {

    }
}
