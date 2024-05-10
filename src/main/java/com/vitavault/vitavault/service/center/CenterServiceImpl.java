package com.vitavault.vitavault.service.center;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.Center;
import com.vitavault.vitavault.model.enums.SubscriptionStatus;
import com.vitavault.vitavault.model.input.InputCenter;
import com.vitavault.vitavault.repository.CenterRepository;
import com.vitavault.vitavault.service.address.IAddressService;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.billingDetail.IBillingDetailService;
import com.vitavault.vitavault.service.type.center.ICenterTypeService;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CenterServiceImpl extends BaseServiceImpl<Center, CenterRepository> implements ICenterService {
    @Autowired
    private IValidateProperty validate;

    @Autowired
    private CenterRepository repository;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private ICenterTypeService centerTypeService;

    @Autowired
    private IBillingDetailService billingDetailService;

    @Override
    public void create(InputCenter input) {
        if (!validate.isNonEmptyString(input.name()))
            throw new InvalidRequestException("Center: name is required.");

        if (!validate.isNonEmptyString(input.phoneNumber()))
            throw new InvalidRequestException("Center: phone number is required.");

        if (!validate.isNonEmptyString(input.email()))
            throw new InvalidRequestException("Center: email is required.");

        if (!validate.isUUID(input.address()))
            throw new InvalidRequestException("Center: address is required.");

        if (!validate.isUUID(input.centerType()))
            throw new InvalidRequestException("Center: tax is required.");

        if (!validate.isUUID(input.billingDetail()))
            throw new InvalidRequestException("Center: tax is required.");

        repository.save(
                Center.builder()
                        .name(input.name())
                        .phoneNumber(input.phoneNumber())
                        .email(input.email())
                        .subscriptionStart(input.subscriptionStart())
                        .subscriptionEnd(input.subscriptionEnd())
                        .phoneNumber(input.phoneNumber())
                        .address(addressService.getByID(input.address()))
                        .subscriptionStatus(SubscriptionStatus.INACTIVE)
                        .centerType(centerTypeService.getByID(input.centerType()))
                        .billingDetail(billingDetailService.getByID(input.billingDetail()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputCenter input) {
        Center center = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Center: not found ID."));

        if (validate.isNonEmptyString(input.name()))
            center.setName(input.name());

        if (validate.isNonEmptyString(input.phoneNumber()))
            center.setPhoneNumber(input.phoneNumber());

        if (validate.isNonEmptyString(input.email()))
            center.setEmail(input.email());

        if (validate.isUUID(input.address()))
            center.setAddress(addressService.getByID(input.address()));

        if (validate.isUUID(input.centerType()))
            center.setCenterType(centerTypeService.getByID(input.centerType()));

        if (validate.isUUID(input.billingDetail()))
            center.setBillingDetail(billingDetailService.getByID(input.billingDetail()));

        repository.save(center);
    }
}
