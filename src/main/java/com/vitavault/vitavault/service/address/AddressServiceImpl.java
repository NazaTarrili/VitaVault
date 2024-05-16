package com.vitavault.vitavault.service.address;

import com.vitavault.vitavault.model.domain.Address;
import com.vitavault.vitavault.model.input.InputAddress;
import com.vitavault.vitavault.repository.AddressRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.city.ICityService;
import com.vitavault.vitavault.service.street.IStreetService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, AddressRepository> implements IAddressService {
    private final String className = Address.class.getName();

    @Autowired
    private IStreetService streetService;

    @Autowired
    private ICityService cityService;

    @Override
    @Transactional
    public void create(InputAddress input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("street", input.street()), className);
        requestValidator.invalidRequest(new Property("city", input.city()), className);

        repository.save(
                Address.builder()
                        .number(input.number())
                        .floor(input.floor())
                        .department(input.department())
                        .street(streetService.getByID(input.street()))
                        .city(cityService.getByID(input.city()))
                        .build()
        );
    }

    @Override
    @Transactional
    public void update(UUID id, InputAddress input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Address address = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isInteger(input.number()))
            address.setNumber(input.number());

        if (validate.isNonEmptyString(input.floor()))
            address.setFloor(input.floor());

        if (validate.isNonEmptyString(input.department()))
            address.setDepartment(input.department());

        if (validate.isUUID(input.street()))
            address.setStreet(streetService.getByID(input.street()));

        if (validate.isUUID(input.city()))
            address.setCity(cityService.getByID(input.city()));

        repository.save(address);
    }
}
