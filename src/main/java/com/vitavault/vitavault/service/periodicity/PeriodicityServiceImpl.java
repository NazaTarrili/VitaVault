package com.vitavault.vitavault.service.periodicity;

import com.vitavault.vitavault.model.domain.Periodicity;
import com.vitavault.vitavault.model.input.InputPeriodicity;
import com.vitavault.vitavault.repository.PeriodicityRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PeriodicityServiceImpl extends BaseServiceImpl<Periodicity, PeriodicityRepository> implements IPeriodicityService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputPeriodicity input) {

    }

    @Override
    public void update(UUID id, InputPeriodicity input) {

    }
}
