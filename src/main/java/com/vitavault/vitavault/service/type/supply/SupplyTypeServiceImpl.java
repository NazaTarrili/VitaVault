package com.vitavault.vitavault.service.type.supply;

import com.vitavault.vitavault.model.domain.SupplyType;
import com.vitavault.vitavault.model.input.InputSupplyType;
import com.vitavault.vitavault.repository.SupplyTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SupplyTypeServiceImpl extends BaseServiceImpl<SupplyType, SupplyTypeRepository> implements ISupplyTypeService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputSupplyType input) {

    }

    @Override
    public void update(UUID id, InputSupplyType input) {

    }
}
