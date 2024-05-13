package com.vitavault.vitavault.service.address;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.Address;
import com.vitavault.vitavault.model.input.InputAddress;
import com.vitavault.vitavault.repository.AddressRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.city.ICityService;
import com.vitavault.vitavault.service.street.IStreetService;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, AddressRepository> implements IAddressService {
    @Autowired
    private IValidateProperty validate;

    @Autowired
    private IStreetService streetService;

    @Autowired
    private ICityService cityService;

    @Override
    @Transactional
    public void create(InputAddress input) {
        if (!validate.isUUID(input.street()))
            throw new InvalidRequestException("Address: street is required.");

        if (!validate.isUUID(input.city()))
            throw new InvalidRequestException("Address: city is required.");

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
        Address address = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Address: not found ID."));

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
