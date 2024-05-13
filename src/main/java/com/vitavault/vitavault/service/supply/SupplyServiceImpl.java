package com.vitavault.vitavault.service.supply;

import com.vitavault.vitavault.model.domain.Supply;
import com.vitavault.vitavault.model.input.InputSupply;
import com.vitavault.vitavault.repository.SupplyRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SupplyServiceImpl extends BaseServiceImpl<Supply, SupplyRepository> implements ISupplyService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputSupply input) {

    }

    @Override
    public void update(UUID id, InputSupply input) {

    }
}
