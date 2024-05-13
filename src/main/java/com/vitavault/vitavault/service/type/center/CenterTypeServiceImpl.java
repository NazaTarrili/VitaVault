package com.vitavault.vitavault.service.type.center;

import com.vitavault.vitavault.model.domain.CenterType;
import com.vitavault.vitavault.model.input.InputCenterType;
import com.vitavault.vitavault.repository.CenterTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CenterTypeServiceImpl extends BaseServiceImpl<CenterType, CenterTypeRepository> implements ICenterTypeService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputCenterType input) {

    }

    @Override
    public void update(UUID id, InputCenterType input) {

    }
}
