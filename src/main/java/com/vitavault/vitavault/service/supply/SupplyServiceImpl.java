package com.vitavault.vitavault.service.supply;

import com.vitavault.vitavault.model.domain.Supplier;
import com.vitavault.vitavault.model.domain.Supply;
import com.vitavault.vitavault.model.input.InputSupply;
import com.vitavault.vitavault.repository.SupplyRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.supplier.ISupplierService;
import com.vitavault.vitavault.service.type.supply.ISupplyTypeService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Service
public class SupplyServiceImpl extends BaseServiceImpl<Supply, SupplyRepository> implements ISupplyService {
    private final String className = Supply.class.getName();

    @Autowired
    private ISupplierService supplierService;

    @Autowired
    private ISupplyTypeService supplyTypeService;

    @Override
    public void create(InputSupply input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("stock", input.stock()), className);
        requestValidator.invalidRequest(new Property("due date", input.dueDate()), className);
        requestValidator.invalidRequest(new Property("minimal stock", input.minimalStock()), className);
        requestValidator.invalidRequest(new Property("suppliers", input.suppliers()), className);
        requestValidator.invalidRequest(new Property("supply type", input.supplyType()), className);

        Set<Supplier> suppliers = new HashSet<>();
        for (UUID supplier : input.suppliers()) {
            suppliers.add(supplierService.getByID(supplier));
        }

        repository.save(
                Supply.builder()
                        .name(input.name())
                        .stock(input.stock())
                        .dueDate(input.dueDate())
                        .minimalStock(input.minimalStock())
                        .suppliers(suppliers)
                        .supplyType(supplyTypeService.getByID(input.supplyType()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputSupply input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Supply supply = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            supply.setName(input.name());

        if (validate.isInteger(input.stock()))
            supply.setStock(input.stock());

        if (validate.isLocalDateTime(input.dueDate()))
            supply.setDueDate(input.dueDate());

        if (validate.isInteger(input.minimalStock()))
            supply.setMinimalStock(input.minimalStock());

        if (validate.isNonEmptyUUIDSet(input.suppliers())) {
            Set<Supplier> suppliers = new HashSet<>();

            for (UUID supplier : input.suppliers()) {
                suppliers.add(supplierService.getByID(supplier));
            }

            supply.setSuppliers(suppliers);
        }

        if (validate.isUUID(input.supplyType()))
            supply.setSupplyType(supplyTypeService.getByID(input.supplyType()));

        repository.save(supply);
    }
}
