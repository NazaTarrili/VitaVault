package com.vitavault.vitavault.service.type.center;

import com.vitavault.vitavault.model.domain.CenterType;
import com.vitavault.vitavault.model.input.InputCenterType;
import com.vitavault.vitavault.repository.CenterTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CenterTypeServiceImpl extends BaseServiceImpl<CenterType, CenterTypeRepository> implements ICenterTypeService {
    @Override
    public void create(InputCenterType input) {

    }

    @Override
    public void update(UUID id, InputCenterType input) {

    }
}
