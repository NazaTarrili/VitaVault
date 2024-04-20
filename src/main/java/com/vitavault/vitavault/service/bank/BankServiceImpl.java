package com.vitavault.vitavault.service.bank;

import com.vitavault.vitavault.domain.Bank;
import com.vitavault.vitavault.repository.BankRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class BankServiceImpl extends BaseServiceImpl<Bank, BankRepository> implements IBankService {
}
