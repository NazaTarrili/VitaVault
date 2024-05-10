package com.vitavault.vitavault.service.status.detail;

import com.vitavault.vitavault.model.domain.DetailStatus;
import com.vitavault.vitavault.model.input.InputDetailStatus;
import com.vitavault.vitavault.repository.DetailStatusRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class DetailStatusServiceImpl extends BaseServiceImpl<DetailStatus, DetailStatusRepository> implements IDetailStatusService {
    @Override
    public void create(InputDetailStatus input) {

    }

    @Override
    public void update(UUID id, InputDetailStatus input) {

    }
}
