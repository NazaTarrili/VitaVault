package com.vitavault.vitavault.service.billingDetail;

import com.vitavault.vitavault.model.domain.BillingDetail;
import com.vitavault.vitavault.model.input.InputBillingDetail;
import com.vitavault.vitavault.repository.BillingDetailRepository;
import com.vitavault.vitavault.service.address.IAddressService;
import com.vitavault.vitavault.service.bank.IBankService;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.person.IPersonService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BillingDetailServiceImpl extends BaseServiceImpl<BillingDetail, BillingDetailRepository> implements IBillingDetailService {
    private final String className = BillingDetail.class.getName();

    @Autowired
    private IBankService bankService;

    @Autowired
    private IPersonService personService;

    @Autowired
    private IAddressService addressService;

    @Override
    public void create(InputBillingDetail input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("tax identifier", input.taxIdentifier()), className);
        requestValidator.invalidRequest(new Property("email", input.email()), className);
        requestValidator.invalidRequest(new Property("account number", input.accountNumber()), className);
        requestValidator.invalidRequest(new Property("iban", input.iban()), className);
        requestValidator.invalidRequest(new Property("phone number", input.phoneNumber()), className);
        requestValidator.invalidRequest(new Property("bank", input.bank()), className);
        requestValidator.invalidRequest(new Property("person", input.person()), className);
        requestValidator.invalidRequest(new Property("address", input.address()), className);

        repository.save(
                BillingDetail.builder()
                        .taxIdentifier(input.taxIdentifier())
                        .email(input.email())
                        .accountNumber(input.accountNumber())
                        .reference(input.reference())
                        .iban(input.iban())
                        .phoneNumber(input.phoneNumber())
                        .bank(bankService.getByID(input.bank()))
                        .person(personService.getByID(input.person()))
                        .address(addressService.getByID(input.address()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputBillingDetail input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        BillingDetail billingDetail = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.taxIdentifier()))
            billingDetail.setTaxIdentifier(input.taxIdentifier());

        if (validate.isNonEmptyString(input.email()))
            billingDetail.setEmail(input.email());

        if (validate.isNonEmptyString(input.accountNumber()))
            billingDetail.setAccountNumber(input.accountNumber());

        if (validate.isNonEmptyString(input.iban()))
            billingDetail.setIban(input.iban());

        if (validate.isNonEmptyString(input.phoneNumber()))
            billingDetail.setPhoneNumber(input.phoneNumber());

        if (validate.isUUID(input.bank()))
            billingDetail.setBank(bankService.getByID(input.bank()));

        if (validate.isUUID(input.person()))
            billingDetail.setPerson(personService.getByID(input.person()));

        if (validate.isUUID(input.address()))
            billingDetail.setAddress(addressService.getByID(input.address()));

        repository.save(billingDetail);
    }
}
