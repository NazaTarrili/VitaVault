package com.vitavault.vitavault.service.bank;

import com.vitavault.vitavault.model.domain.Bank;
import com.vitavault.vitavault.model.input.InputBank;
import com.vitavault.vitavault.repository.BankRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BankServiceImpl extends BaseServiceImpl<Bank, BankRepository> implements IBankService {
    private final String className = Bank.class.getName();

    @Override
    public void create(InputBank input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new Bank(input.name()));
    }

    @Override
    public void update(UUID id, InputBank input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Bank bank = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            bank.setName(input.name());

        repository.save(bank);
    }
}
