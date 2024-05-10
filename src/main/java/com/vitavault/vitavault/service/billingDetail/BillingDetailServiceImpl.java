package com.vitavault.vitavault.service.billingDetail;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.BillingDetail;
import com.vitavault.vitavault.model.input.InputBillingDetail;
import com.vitavault.vitavault.repository.BillingDetailRepository;
import com.vitavault.vitavault.service.address.IAddressService;
import com.vitavault.vitavault.service.bank.IBankService;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.person.IPersonService;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BillingDetailServiceImpl extends BaseServiceImpl<BillingDetail, BillingDetailRepository> implements IBillingDetailService {
    @Autowired
    private IValidateProperty validate;

    @Autowired
    private BillingDetailRepository repository;

    @Autowired
    private IBankService bankService;

    @Autowired
    private IPersonService personService;

    @Autowired
    private IAddressService addressService;

    @Override
    public void create(InputBillingDetail input) {
        if (!validate.isNonEmptyString(input.taxIdentifier()))
            throw new InvalidRequestException("BillingDetail: tax identifier is required.");

        if (!validate.isNonEmptyString(input.email()))
            throw new InvalidRequestException("BillingDetail: email is required.");

        if (!validate.isNonEmptyString(input.accountNumber()))
            throw new InvalidRequestException("BillingDetail: account number is required.");

        if (!validate.isNonEmptyString(input.iban()))
            throw new InvalidRequestException("BillingDetail: iban is required.");

        if (!validate.isNonEmptyString(input.phoneNumber()))
            throw new InvalidRequestException("BillingDetail: phone number is required.");

        if (!validate.isUUID(input.bank()))
            throw new InvalidRequestException("BillingDetail: bank is required.");

        if (!validate.isUUID(input.person()))
            throw new InvalidRequestException("BillingDetail: person is required.");

        if (!validate.isUUID(input.address()))
            throw new InvalidRequestException("BillingDetail: address is required.");

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
        BillingDetail billingDetail = repository.findById(id).orElseThrow(() ->
                new NotFoundException("BillingDetail: not found ID."));

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
