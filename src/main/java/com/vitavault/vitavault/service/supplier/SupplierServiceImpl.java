package com.vitavault.vitavault.service.supplier;

import com.vitavault.vitavault.model.domain.Supplier;
import com.vitavault.vitavault.model.input.InputSupplier;
import com.vitavault.vitavault.repository.SupplierRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier, SupplierRepository> implements ISupplierService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputSupplier input) {

    }

    @Override
    public void update(UUID id, InputSupplier input) {

    }
}
