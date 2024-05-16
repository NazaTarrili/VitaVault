package com.vitavault.vitavault.service.supplier;

import com.vitavault.vitavault.model.domain.Supplier;
import com.vitavault.vitavault.model.input.InputSupplier;
import com.vitavault.vitavault.repository.SupplierRepository;
import com.vitavault.vitavault.service.address.IAddressService;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier, SupplierRepository> implements ISupplierService {
    private final String className = Supplier.class.getName();

    @Autowired
    private IAddressService addressService;

    @Override
    public void create(InputSupplier input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("address", input.address()), className);

        repository.save(
                Supplier.builder()
                        .name(input.name())
                        .address(addressService.getByID(input.address()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputSupplier input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Supplier supplier = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            supplier.setName(input.name());

        if (validate.isUUID(input.address()))
            supplier.setAddress(addressService.getByID(input.address()));

        repository.save(supplier);
    }
}
