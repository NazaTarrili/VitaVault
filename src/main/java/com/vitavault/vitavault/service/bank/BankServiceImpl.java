package com.vitavault.vitavault.service.bank;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.Bank;
import com.vitavault.vitavault.model.input.InputBank;
import com.vitavault.vitavault.repository.BankRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BankServiceImpl extends BaseServiceImpl<Bank, BankRepository> implements IBankService {
    @Autowired
    private IValidateProperty validate;

    @Autowired
    private BankRepository repository;

    @Override
    public void create(InputBank input) {
        if (!validate.isNonEmptyString(input.name()))
            throw new InvalidRequestException("Bank: name is required.");

        repository.save(new Bank(input.name()));
    }

    @Override
    public void update(UUID id, InputBank input) {
        Bank bank = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Bank: not found ID."));

        if (validate.isNonEmptyString(input.name()))
            bank.setName(input.name());

        repository.save(bank);
    }
}
