package com.vitavault.vitavault.service.status.detail;

import com.vitavault.vitavault.model.domain.DetailStatus;
import com.vitavault.vitavault.model.input.InputDetailStatus;
import com.vitavault.vitavault.repository.DetailStatusRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class DetailStatusServiceImpl extends BaseServiceImpl<DetailStatus, DetailStatusRepository> implements IDetailStatusService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputDetailStatus input) {

    }

    @Override
    public void update(UUID id, InputDetailStatus input) {

    }
}
