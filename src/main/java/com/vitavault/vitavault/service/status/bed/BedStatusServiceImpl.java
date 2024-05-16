package com.vitavault.vitavault.service.status.bed;

import com.vitavault.vitavault.model.domain.BedStatus;
import com.vitavault.vitavault.model.input.InputBedStatus;
import com.vitavault.vitavault.repository.BedStatusRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BedStatusServiceImpl extends BaseServiceImpl<BedStatus, BedStatusRepository> implements IBedStatusService {
    private final String className = BedStatus.class.getName();

    @Override
    public void create(InputBedStatus input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new BedStatus(input.name()));
    }

    @Override
    public void update(UUID id, InputBedStatus input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        BedStatus bedStatus = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        bedStatus.setName(input.name());

        repository.save(bedStatus);
    }
}
