package com.vitavault.vitavault.service.status.bed;

import com.vitavault.vitavault.model.domain.BedStatus;
import com.vitavault.vitavault.model.input.InputBedStatus;
import com.vitavault.vitavault.repository.BedStatusRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BedStatusServiceImpl extends BaseServiceImpl<BedStatus, BedStatusRepository> implements IBedStatusService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputBedStatus input) {

    }

    @Override
    public void update(UUID id, InputBedStatus input) {

    }
}
