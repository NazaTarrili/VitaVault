package com.vitavault.vitavault.service.status.detail;

import com.vitavault.vitavault.model.domain.DetailStatus;
import com.vitavault.vitavault.model.input.InputDetailStatus;
import com.vitavault.vitavault.repository.DetailStatusRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class DetailStatusServiceImpl extends BaseServiceImpl<DetailStatus, DetailStatusRepository> implements IDetailStatusService {
    private final String className = DetailStatus.class.getName();

    @Override
    public void create(InputDetailStatus input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new DetailStatus(input.name()));
    }

    @Override
    public void update(UUID id, InputDetailStatus input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        DetailStatus detailStatus = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            detailStatus.setName(input.name());

        repository.save(detailStatus);
    }
}
