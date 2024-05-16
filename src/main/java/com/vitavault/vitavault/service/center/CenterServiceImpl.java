package com.vitavault.vitavault.service.center;

import com.vitavault.vitavault.model.domain.Center;
import com.vitavault.vitavault.model.input.InputCenter;
import com.vitavault.vitavault.model.types.SubscriptionStatus;
import com.vitavault.vitavault.repository.CenterRepository;
import com.vitavault.vitavault.service.address.IAddressService;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.billingDetail.IBillingDetailService;
import com.vitavault.vitavault.service.type.center.ICenterTypeService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CenterServiceImpl extends BaseServiceImpl<Center, CenterRepository> implements ICenterService {
    private final String className = Center.class.getName();

    @Autowired
    private IAddressService addressService;

    @Autowired
    private ICenterTypeService centerTypeService;

    @Autowired
    private IBillingDetailService billingDetailService;

    @Override
    public void create(InputCenter input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("phone number", input.phoneNumber()), className);
        requestValidator.invalidRequest(new Property("email", input.email()), className);
        requestValidator.invalidRequest(new Property("address", input.address()), className);
        requestValidator.invalidRequest(new Property("tax", input.centerType()), className);
        requestValidator.invalidRequest(new Property("billing detail", input.billingDetail()), className);

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
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Center center = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

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
